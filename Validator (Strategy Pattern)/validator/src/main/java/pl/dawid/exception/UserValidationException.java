package pl.dawid.exception;

public class UserValidationException extends RuntimeException {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public UserValidationException(String s) {
        super(s);
    }
}