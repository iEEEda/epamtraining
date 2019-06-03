package kz.eduard.gift.exception;

public class SugarLevelException extends Exception {
    public SugarLevelException() {
    }

    public SugarLevelException(String message) {
        super(message);
    }

    public SugarLevelException(String message, Throwable cause) {
        super(message, cause);
    }

    public SugarLevelException(Throwable cause) {
        super(cause);
    }
}
