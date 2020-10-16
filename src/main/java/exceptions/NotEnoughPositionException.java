package exceptions;

public class NotEnoughPositionException extends RuntimeException {
    public NotEnoughPositionException(String message) {
        super(message);
    }
}
