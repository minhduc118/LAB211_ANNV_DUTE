package service;

import java.util.HashMap;
import model.Doctor;

public interface DoctorService {

    boolean addDoctor(Doctor doctor) throws Exception;

    boolean updateDoctor(Doctor doctor) throws Exception;

    boolean deleteDoctor(Doctor doctor) throws Exception;

    HashMap<String, Doctor> searchDoctor(String input) throws Exception;
}
