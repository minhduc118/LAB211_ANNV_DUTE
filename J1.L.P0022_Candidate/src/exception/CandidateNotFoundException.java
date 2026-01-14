package exception;

public class CandidateNotFoundException extends SystemException {

    public CandidateNotFoundException(String id) {
        super("Candidate with ID '" + id + "' not found.");
    }
}
