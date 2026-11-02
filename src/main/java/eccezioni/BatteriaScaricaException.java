package eccezioni;

public class BatteriaScaricaException extends RossiGoException {

    public BatteriaScaricaException(String message) {
        super(message);
    }

    public BatteriaScaricaException(String message, Throwable causa) {
        super(message, causa);
    }
}
