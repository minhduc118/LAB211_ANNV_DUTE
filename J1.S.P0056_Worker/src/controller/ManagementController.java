package controller;

import constants.Messages;
import exception.SystemException;
import model.Worker;
import service.ManagementService;
import service.ManagementServiceImpl;
import util.Validator;

public class ManagementController {

    private ManagementService service;

    public ManagementController() {
        this.service = new ManagementServiceImpl();
    }

    public void run() {
        while (true) {
            displayMenu();
            int choice = Validator.getInt(Messages.PROMPT_CHOICE, 1, 5);

            switch (choice) {
                case 1:
                    addWorker();
                    break;
                case 2:
                    increaseSalary();
                    break;
                case 3:
                    decreaseSalary();
                    break;
                case 4:
                    displayInformation();
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

    private void addWorker() {
        try {
            System.out.println("\n" + Messages.TITLE_ADD_WORKER);

            String code = Validator.getString(Messages.PROMPT_CODE);
            String name = Validator.getString(Messages.PROMPT_NAME);
            int age = Validator.getInt(Messages.PROMPT_AGE, Messages.MIN_AGE, Messages.MAX_AGE);
            double salary = Validator.getDouble(Messages.PROMPT_SALARY, 0, Double.MAX_VALUE);
            String workLocation = Validator.getString(Messages.PROMPT_WORK_LOCATION);

            Worker worker = new Worker(code, name, age, salary, workLocation);

            service.addWorker(worker);
            System.out.println(Messages.SUCCESS_ADD_WORKER);
        } catch (SystemException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    private void increaseSalary() {
        try {
            System.out.println("\n" + Messages.TITLE_UP_DOWN_SALARY);

            String code = Validator.getString(Messages.PROMPT_CODE);
            double amount = Validator.getDouble(Messages.PROMPT_AMOUNT, 0, Double.MAX_VALUE);

            service.changeSalary(code, amount, true);
            System.out.println(Messages.SUCCESS_INCREASE_SALARY);
        } catch (SystemException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    private void decreaseSalary() {
        try {
            System.out.println("\n" + Messages.TITLE_UP_DOWN_SALARY);

            String code = Validator.getString(Messages.PROMPT_CODE);
            double amount = Validator.getDouble(Messages.PROMPT_AMOUNT, 0, Double.MAX_VALUE);

            service.changeSalary(code, amount, false);
            System.out.println(Messages.SUCCESS_DECREASE_SALARY);
        } catch (SystemException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    private void displayInformation() {
        service.getInformationSalary();
    }
}
