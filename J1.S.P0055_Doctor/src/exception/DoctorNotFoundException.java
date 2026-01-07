package exception;

public class DoctorNotFoundException extends SystemException {

    public DoctorNotFoundException() {
        super("Doctor code doesn't exist");
    }

    public DoctorNotFoundException(String code) {
        super("Doctor code " + code + " doesn't exist");
    }
}
