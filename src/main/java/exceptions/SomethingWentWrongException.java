package exceptions;

public class SomethingWentWrongException extends RuntimeException {

    public SomethingWentWrongException(String message) {
        super(message);
    }
}
