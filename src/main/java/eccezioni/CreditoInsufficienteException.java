package eccezioni;

public class CreditoInsufficienteException extends RossiGoException {
    public CreditoInsufficienteException(String message) {
        super(message);
    }

    public CreditoInsufficienteException(String message, Throwable causa) {
        super(message, causa);
    }
}
