package exception;

/**
 * The type Input validation failed exception.
 * @author Ariana Horvath
 */
public class InputValidationFailedException extends RuntimeException {

    /**
     * Instantiates a new Input validation failed exception.
     *
     * @param message the message
     */
    public InputValidationFailedException(String message) {
        super(message);
    }
}
