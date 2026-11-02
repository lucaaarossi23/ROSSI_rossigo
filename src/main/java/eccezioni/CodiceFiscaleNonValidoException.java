package eccezioni;

public class CodiceFiscaleNonValidoException extends RossiGoException {
    public CodiceFiscaleNonValidoException(String message) {
        super(message);
    }

    public CodiceFiscaleNonValidoException(String message, Throwable causa) {
        super(message, causa);
    }
}
