package exception;

public class DuplicateDoctorException extends SystemException {

    public DuplicateDoctorException(String code) {
        super("Doctor code " + code + " is duplicate");
    }
}
