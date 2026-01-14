package controller;

import java.util.List;
import constants.Messages;
import exception.DuplicateCandidateException;
import model.Candidate;
import model.Experience;
import model.Fresher;
import model.Internship;
import service.CandidateService;
import service.CandidateServiceImpl;
import util.Validator;
import view.MenuView;

public class CandidateController {

    private CandidateService service;

    public CandidateController() {
        this.service = new CandidateServiceImpl();
    }

    public void run() {
        while (true) {
            MenuView.displayMenu();
            int choice = Validator.getInt(Messages.PROMPT_CHOICE, 1, 5);

            switch (choice) {
                case 1:
                    addExperience();
                    break;
                case 2:
                    addFresher();
                    break;
                case 3:
                    addInternship();
                    break;
                case 4:
                    searchCandidate();
                    break;
                case 5:
                    MenuView.displaySuccess(Messages.EXIT_MESSAGE);
                    return;
            }
        }
    }

    private void addExperience() {
        do {
            MenuView.displayTitle(Messages.TITLE_ADD_EXPERIENCE);

            String id = Validator.getString(Messages.PROMPT_ID);

            if (service.candidateExists(id)) {
                MenuView.displayError(Messages.ERROR_ID_EXISTS);
                continue;
            }

            String firstName = Validator.getString(Messages.PROMPT_FIRST_NAME);
            String lastName = Validator.getString(Messages.PROMPT_LAST_NAME);
            int birthDate = Validator.getBirthYear(Messages.PROMPT_BIRTH_YEAR);
            String address = Validator.getString(Messages.PROMPT_ADDRESS);
            String phone = Validator.getPhone(Messages.PROMPT_PHONE);
            String email = Validator.getEmail(Messages.PROMPT_EMAIL);

            int yearExperience = Validator.getExperience(Messages.PROMPT_YEAR_EXPERIENCE, birthDate);
            String professionalSkill = Validator.getString(Messages.PROMPT_PROFESSIONAL_SKILL);

            Experience candidate = new Experience(id, firstName, lastName, birthDate,
                    address, phone, email, 0, yearExperience, professionalSkill);

            try {
                service.addCandidate(candidate);
                MenuView.displaySuccess(Messages.SUCCESS_CREATE);
            } catch (DuplicateCandidateException e) {
                MenuView.displayError(e.getMessage());
            }

        } while (Validator.checkYN(Messages.PROMPT_CONTINUE).equalsIgnoreCase("Y"));
    }

    private void addFresher() {
        do {
            MenuView.displayTitle(Messages.TITLE_ADD_FRESHER);

            String id = Validator.getString(Messages.PROMPT_ID);

            if (service.candidateExists(id)) {
                MenuView.displayError(Messages.ERROR_ID_EXISTS);
                continue;
            }

            String firstName = Validator.getString(Messages.PROMPT_FIRST_NAME);
            String lastName = Validator.getString(Messages.PROMPT_LAST_NAME);
            int birthDate = Validator.getBirthYear(Messages.PROMPT_BIRTH_YEAR);
            String address = Validator.getString(Messages.PROMPT_ADDRESS);
            String phone = Validator.getPhone(Messages.PROMPT_PHONE);
            String email = Validator.getEmail(Messages.PROMPT_EMAIL);

            String graduationDate = Validator.getString(Messages.PROMPT_GRADUATION_DATE);
            String graduationRank = Validator.getGraduationRank(Messages.PROMPT_GRADUATION_RANK);

            Fresher candidate = new Fresher(id, firstName, lastName, birthDate,
                    address, phone, email, 1, graduationDate, graduationRank);

            try {
                service.addCandidate(candidate);
                MenuView.displaySuccess(Messages.SUCCESS_CREATE);
            } catch (DuplicateCandidateException e) {
                MenuView.displayError(e.getMessage());
            }

        } while (Validator.checkYN(Messages.PROMPT_CONTINUE).equalsIgnoreCase("Y"));
    }

    private void addInternship() {
        do {
            MenuView.displayTitle(Messages.TITLE_ADD_INTERNSHIP);

            String id = Validator.getString(Messages.PROMPT_ID);

            if (service.candidateExists(id)) {
                MenuView.displayError(Messages.ERROR_ID_EXISTS);
                continue;
            }

            String firstName = Validator.getString(Messages.PROMPT_FIRST_NAME);
            String lastName = Validator.getString(Messages.PROMPT_LAST_NAME);
            int birthDate = Validator.getBirthYear(Messages.PROMPT_BIRTH_YEAR);
            String address = Validator.getString(Messages.PROMPT_ADDRESS);
            String phone = Validator.getPhone(Messages.PROMPT_PHONE);
            String email = Validator.getEmail(Messages.PROMPT_EMAIL);

            String major = Validator.getString(Messages.PROMPT_MAJOR);
            String semester = Validator.getString(Messages.PROMPT_SEMESTER);
            String university = Validator.getString(Messages.PROMPT_UNIVERSITY);

            Internship candidate = new Internship(id, firstName, lastName, birthDate,
                    address, phone, email, 2, major, semester, university);

            try {
                service.addCandidate(candidate);
                MenuView.displaySuccess(Messages.SUCCESS_CREATE);
            } catch (DuplicateCandidateException e) {
                MenuView.displayError(e.getMessage());
            }

        } while (Validator.checkYN(Messages.PROMPT_CONTINUE).equalsIgnoreCase("Y"));
    }

    private void searchCandidate() {
        MenuView.displayTitle(Messages.TITLE_SEARCH);

        service.printCandidatesByType();

        String name = Validator.getString(Messages.PROMPT_SEARCH_NAME);
        int type = Validator.getInt(Messages.PROMPT_SEARCH_TYPE,
                Messages.MIN_CANDIDATE_TYPE, Messages.MAX_CANDIDATE_TYPE);

        List<Candidate> results = service.searchByName(name, type);
        MenuView.displaySearchResults(results);
    }
}
