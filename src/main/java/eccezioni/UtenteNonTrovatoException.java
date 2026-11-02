package eccezioni;

public class UtenteNonTrovatoException extends RossiGoException {
    public UtenteNonTrovatoException(String message) {
        super(message);
    }

    public UtenteNonTrovatoException(String message, Throwable causa) {
        super(message, causa);
    }
}
