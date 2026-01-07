package exception;

public class InvalidDataException extends SystemException {

    public InvalidDataException() {
        super("Data doesn't exist");
    }

    public InvalidDataException(String message) {
        super(message);
    }
}
