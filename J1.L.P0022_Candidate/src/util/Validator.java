package util;

import java.util.Calendar;
import java.util.Scanner;
import constants.Messages;

public final class Validator {

    private static Scanner sc = new Scanner(System.in);

    private Validator() {
    }

    public static String getString(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = sc.nextLine().trim();
            if (!input.isEmpty()) {
                return input;
            }
            System.err.println(Messages.ERROR_EMPTY_INPUT);
        }
    }

    public static int getInt(String prompt, int min, int max) {
        while (true) {
            try {
                System.out.print(prompt);
                String input = sc.nextLine().trim();
                if (input.isEmpty()) {
                    System.err.println(Messages.ERROR_EMPTY_INPUT);
                    continue;
                }
                int number = Integer.parseInt(input);
                if (number >= min && number <= max) {
                    return number;
                }
                System.err.println(String.format(Messages.ERROR_INVALID_RANGE, min, max));
            } catch (NumberFormatException e) {
                System.err.println(Messages.ERROR_INVALID_NUMBER);
            }
        }
    }

    public static String checkYN(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = sc.nextLine().trim();
            if (input.equalsIgnoreCase("Y") || input.equalsIgnoreCase("N")) {
                return input.toUpperCase();
            }
            System.err.println(Messages.ERROR_INVALID_YN);
        }
    }

    public static String getPhone(String prompt) {
        while (true) {
            String input = getString(prompt);
            if (input.matches(Messages.PHONE_PATTERN)) {
                return input;
            }
            System.err.println(Messages.ERROR_INVALID_PHONE);
        }
    }

    public static String getEmail(String prompt) {
        while (true) {
            String input = getString(prompt);
            if (input.matches(Messages.EMAIL_PATTERN)) {
                return input;
            }
            System.err.println(Messages.ERROR_INVALID_EMAIL);
        }
    }

    public static String getGraduationRank(String prompt) {
        while (true) {
            String input = getString(prompt);
            if (input.equalsIgnoreCase("Excellence") ||
                    input.equalsIgnoreCase("Good") ||
                    input.equalsIgnoreCase("Fair") ||
                    input.equalsIgnoreCase("Poor")) {
                return input;
            }
            System.err.println(Messages.ERROR_INVALID_RANK);
        }
    }

    public static int getExperience(String prompt, int birthYear) {
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        int age = currentYear - birthYear;
        while (true) {
            int experience = getInt(prompt, Messages.MIN_EXPERIENCE, Messages.MAX_EXPERIENCE);
            if (experience <= age) {
                return experience;
            }
            System.err.println(Messages.ERROR_EXPERIENCE_GREATER_THAN_AGE);
        }
    }

    public static int getBirthYear(String prompt) {
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        return getInt(prompt, Messages.MIN_BIRTH_YEAR, currentYear);
    }
}
