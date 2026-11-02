package modello;

import servizio.Utente;

public abstract class Veicolo {
    private String codice;
    private int livelloBatteria;
    private String stato;
    private Utente utenteAttuale;

    public Veicolo(String codice, int livelloBatteria, String stato) {
        this.codice = codice;
        this.livelloBatteria = livelloBatteria;
        this.stato = stato;
    }

    public Utente getUtenteAttuale() {
        return utenteAttuale;
    }

    public void setUtenteAttuale(Utente utenteAttuale) {
        this.utenteAttuale = utenteAttuale;
    }

    public void setStato(String stato) {
        this.stato = stato;
    }

    public void setLivelloBatteria(int livelloBatteria) {
        this.livelloBatteria = livelloBatteria;
    }

    public String getCodice() {
        return codice;
    }

    public int getLivelloBatteria() {
        return livelloBatteria;
    }

    public String getStato() {
        return stato;
    }

    public abstract double calcolaCosto(int minuti);
    public abstract double consumoBatteriaPerMinuto();

}
