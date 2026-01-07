package exception;

public class DatabaseNotFoundException extends SystemException {

    public DatabaseNotFoundException() {
        super("Database does not exist");
    }
}
