package servizio;
import modello.Veicolo;
import java.time.LocalTime;

public class Noleggio {
    private Utente utente;
    private Veicolo veicolo;
    private LocalTime orarioInizio;
    private LocalTime orarioFine;

    public Utente getUtente() {
        return utente;
    }

    public Veicolo getVeicolo() {
        return veicolo;
    }

    public LocalTime getOrarioInizio() {
        return orarioInizio;
    }

    public LocalTime getOrarioFine() {
        return orarioFine;
    }
}
