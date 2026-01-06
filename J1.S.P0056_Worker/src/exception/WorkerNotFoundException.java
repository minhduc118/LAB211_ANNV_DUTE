package exception;

public class WorkerNotFoundException extends SystemException {

    public WorkerNotFoundException(String code) {
        super("Worker with code '" + code + "' does not exist in the database.");
    }
}
