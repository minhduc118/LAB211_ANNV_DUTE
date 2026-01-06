package exception;

public class DuplicateWorkerException extends SystemException {

    public DuplicateWorkerException(String code) {
        super("Worker with code '" + code + "' already exists in the database.");
    }
}
