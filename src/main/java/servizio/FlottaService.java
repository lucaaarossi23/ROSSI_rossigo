package servizio;

import eccezioni.*;
import it.kamaladafrica.codicefiscale.CodiceFiscale;
import modello.Veicolo;

import java.util.ArrayList;

public class FlottaService {
    private ArrayList<Veicolo> veicoli = new ArrayList<>();
    private ArrayList<Utente> utenti = new ArrayList<>();

    public void registraVeicolo(Veicolo v) {
        veicoli.add(v);
    }

    public void registraUtente(Utente u) throws CodiceFiscaleNonValidoException {
        if(!CodiceFiscale.isFormatValid(u.getCodiceFiescale())) {
            throw new CodiceFiscaleNonValidoException("Codice fiscale non valido");
        }

        utenti.add(u);
    }

    public void sbloccaVeicolo(String codice, String idUtente) throws VeicoloNonDisponibileException, BatteriaScaricaException, UtenteNonTrovatoException, CreditoInsufficienteException {
        for (int i = 0; i < veicoli.size(); i++) {
            Veicolo v = veicoli.get(i);
            if (v.getCodice().equals(codice)) {
                if (v.getStato().equals("LIBERO")) {
                    if (v.getLivelloBatteria() >= 15) {
                        for (int j = 0; j < utenti.size(); j++) {
                            Utente u = utenti.get(j);
                            if (u.getID().equals(idUtente)) {
                                if (u.getCredito() >= 1) {
                                    v.setStato("IN_USO");
                                    v.setUtenteAttuale(u);
                                    return;
                                } else {
                                    throw new CreditoInsufficienteException(
                                            "Credito insufficiente: " + u.getCredito()
                                    );
                                }
                            }
                        }
                        throw new UtenteNonTrovatoException("L'utente non esiste");
                    } else {
                        throw new BatteriaScaricaException(
                                "La batteria del veicolo è scarica (" + v.getLivelloBatteria() + "%)"
                        );
                    }
                } else {
                    throw new VeicoloNonDisponibileException("Il veicolo non è disponibile");
                }
            }
        }
        throw new VeicoloNonDisponibileException("Il veicolo non esiste");
    }

    public void terminaNoleggio(String codice, int minutiUsati) {
        for (int i = 0; i < veicoli.size(); i++) {
            Veicolo v = veicoli.get(i);
            if (v.getCodice().equals(codice)) {
                Utente u = v.getUtenteAttuale();
                double accredito = (v.calcolaCosto(minutiUsati)) + 1;
                u.setCredito(u.getCredito()-accredito);
                v.setStato("LIBERO");
                v.setUtenteAttuale(null);
                v.setLivelloBatteria((int) (v.getLivelloBatteria()-(v.consumoBatteriaPerMinuto() * minutiUsati)));
                return;
            }
        }
    }

    public void mettiInRicarica(String codice) {
        for (int i = 0; i < veicoli.size(); i++) {
            Veicolo v = veicoli.get(i);
            if (v.getCodice().equals(codice)) {
                v.setStato("IN_CARICA");
                return;
            }
        }
    }
}
