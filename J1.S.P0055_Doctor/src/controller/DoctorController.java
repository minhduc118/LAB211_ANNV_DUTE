package controller;

import constants.Messages;
import dto.DoctorDTO;
import exception.SystemException;
import java.util.HashMap;
import model.Doctor;
import service.DoctorService;
import service.DoctorServiceImpl;
import util.Validator;

public class DoctorController {

    private DoctorService service;

    public DoctorController() {
        this.service = new DoctorServiceImpl();
    }

    public void run() {
        while (true) {
            displayMenu();
            int choice = Validator.getInt(Messages.PROMPT_CHOICE, 1, 5);

            switch (choice) {
                case 1:
                    addDoctor();
                    break;
                case 2:
                    updateDoctor();
                    break;
                case 3:
                    deleteDoctor();
                    break;
                case 4:
                    searchDoctor();
                    break;
                case 5:
                    System.out.println(Messages.EXIT_MESSAGE);
                    return;
            }
        }
    }

    private void displayMenu() {
        System.out.println("\n" + Messages.MENU_TITLE);
        System.out.println(Messages.MENU_OPTION_1);
        System.out.println(Messages.MENU_OPTION_2);
        System.out.println(Messages.MENU_OPTION_3);
        System.out.println(Messages.MENU_OPTION_4);
        System.out.println(Messages.MENU_OPTION_5);
    }

    private void addDoctor() {
        try {
            System.out.println("\n" + Messages.TITLE_ADD_DOCTOR);

            String code = Validator.getString(Messages.PROMPT_CODE);
            String name = Validator.getString(Messages.PROMPT_NAME);
            String specialization = Validator.getString(Messages.PROMPT_SPECIALIZATION);
            int availability = Validator.getInt(Messages.PROMPT_AVAILABILITY,
                    Messages.MIN_AVAILABILITY, Messages.MAX_AVAILABILITY);

            Doctor doctor = new Doctor(code, name, specialization, availability);

            service.addDoctor(doctor);
            System.out.println(Messages.SUCCESS_ADD_DOCTOR);
        } catch (SystemException e) {
            System.err.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    private void updateDoctor() {
        try {
            System.out.println("\n" + Messages.TITLE_UPDATE_DOCTOR);

            String code = Validator.getString(Messages.PROMPT_CODE);

            // Create a DTO to collect update data
            DoctorDTO dto = new DoctorDTO();
            dto.setCode(code);

            System.out.println("(Leave blank to keep current value)");

            String name = Validator.getStringAllowEmpty(Messages.PROMPT_NAME);
            String specialization = Validator.getStringAllowEmpty(Messages.PROMPT_SPECIALIZATION);
            Integer availability = Validator.getIntAllowEmpty(Messages.PROMPT_AVAILABILITY,
                    Messages.MIN_AVAILABILITY, Messages.MAX_AVAILABILITY);

            // Create doctor object for update
            Doctor doctor = new Doctor();
            doctor.setCode(code);
            doctor.setName(name.isEmpty() ? null : name);
            doctor.setSpecialization(specialization.isEmpty() ? null : specialization);
            doctor.setAvailability(availability != null ? availability : -1);

            service.updateDoctor(doctor);
            System.out.println(Messages.SUCCESS_UPDATE_DOCTOR);
        } catch (SystemException e) {
            System.err.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    private void deleteDoctor() {
        try {
            System.out.println("\n" + Messages.TITLE_DELETE_DOCTOR);

            String code = Validator.getString(Messages.PROMPT_CODE);

            Doctor doctor = new Doctor();
            doctor.setCode(code);

            String confirm = Validator.checkYN(Messages.PROMPT_CONFIRM_DELETE);
            if (confirm.equals("y")) {
                service.deleteDoctor(doctor);
                System.out.println(Messages.SUCCESS_DELETE_DOCTOR);
            } else {
                System.out.println("Delete cancelled.");
            }
        } catch (SystemException e) {
            System.err.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    private void searchDoctor() {
        try {
            System.out.println("\n" + Messages.TITLE_SEARCH_DOCTOR);

            String searchText = Validator.getString(Messages.PROMPT_SEARCH);

            HashMap<String, Doctor> results = service.searchDoctor(searchText);

            System.out.println(Messages.TITLE_RESULT);

            if (results.isEmpty()) {
                System.out.println(Messages.ERROR_NO_RESULTS);
            } else {
                System.out.println(Messages.TABLE_HEADER);
                for (Doctor doctor : results.values()) {
                    System.out.println(doctor);
                }
            }
        } catch (SystemException e) {
            System.err.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
