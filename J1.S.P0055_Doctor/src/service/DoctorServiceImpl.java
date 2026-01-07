package service;

import exception.DatabaseNotFoundException;
import exception.DoctorNotFoundException;
import exception.DuplicateDoctorException;
import exception.InvalidDataException;
import java.util.HashMap;
import model.Doctor;

public class DoctorServiceImpl implements DoctorService {

    private HashMap<String, Doctor> doctorDB;

    public DoctorServiceImpl() {
        this.doctorDB = new HashMap<>();
    }

    @Override
    public boolean addDoctor(Doctor doctor) throws Exception {
        // Check if database exists
        if (doctorDB == null) {
            throw new DatabaseNotFoundException();
        }

        // Check if doctor data exists
        if (doctor == null) {
            throw new InvalidDataException();
        }

        // Check if code is null or empty
        if (doctor.getCode() == null || doctor.getCode().trim().isEmpty()) {
            throw new InvalidDataException("Doctor code cannot be empty");
        }

        // Check for duplicate code
        if (doctorDB.containsKey(doctor.getCode())) {
            throw new DuplicateDoctorException(doctor.getCode());
        }

        // Add doctor to database
        doctorDB.put(doctor.getCode(), doctor);
        return true;
    }

    @Override
    public boolean updateDoctor(Doctor doctor) throws Exception {
        // Check if database exists
        if (doctorDB == null) {
            throw new DatabaseNotFoundException();
        }

        // Check if doctor data exists
        if (doctor == null) {
            throw new InvalidDataException();
        }

        // Check if code exists
        if (!doctorDB.containsKey(doctor.getCode())) {
            throw new DoctorNotFoundException();
        }

        // Get existing doctor and update only non-null, non-empty fields
        Doctor existingDoctor = doctorDB.get(doctor.getCode());

        if (doctor.getName() != null && !doctor.getName().trim().isEmpty()) {
            existingDoctor.setName(doctor.getName());
        }

        if (doctor.getSpecialization() != null && !doctor.getSpecialization().trim().isEmpty()) {
            existingDoctor.setSpecialization(doctor.getSpecialization());
        }

        if (doctor.getAvailability() >= 0) {
            existingDoctor.setAvailability(doctor.getAvailability());
        }

        // Replace in database
        doctorDB.put(doctor.getCode(), existingDoctor);
        return true;
    }

    @Override
    public boolean deleteDoctor(Doctor doctor) throws Exception {
        // Check if database exists
        if (doctorDB == null) {
            throw new DatabaseNotFoundException();
        }

        // Check if doctor data exists
        if (doctor == null) {
            throw new InvalidDataException();
        }

        // Check if code exists
        if (!doctorDB.containsKey(doctor.getCode())) {
            throw new DoctorNotFoundException();
        }

        // Remove from database
        doctorDB.remove(doctor.getCode());
        return true;
    }

    @Override
    public HashMap<String, Doctor> searchDoctor(String input) throws Exception {
        // Check if database exists
        if (doctorDB == null) {
            throw new DatabaseNotFoundException();
        }

        HashMap<String, Doctor> results = new HashMap<>();

        // Search through all doctors
        for (Doctor doctor : doctorDB.values()) {
            // Search in code, name, and specialization
            if (doctor.getCode().toLowerCase().contains(input.toLowerCase())
                    || doctor.getName().toLowerCase().contains(input.toLowerCase())
                    || doctor.getSpecialization().toLowerCase().contains(input.toLowerCase())) {
                results.put(doctor.getCode(), doctor);
            }
        }

        return results;
    }

    // Helper method to get a doctor by code
    public Doctor getDoctorByCode(String code) {
        return doctorDB.get(code);
    }

    // Helper method to check if doctor exists
    public boolean doctorExists(String code) {
        return doctorDB.containsKey(code);
    }
}
