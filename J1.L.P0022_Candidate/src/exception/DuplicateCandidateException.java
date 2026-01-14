package exception;

public class DuplicateCandidateException extends SystemException {

    public DuplicateCandidateException(String id) {
        super("Candidate with ID '" + id + "' already exists.");
    }
}
