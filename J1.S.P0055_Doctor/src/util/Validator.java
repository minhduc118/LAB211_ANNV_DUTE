package util;

import constants.Messages;
import java.util.Scanner;

public class Validator {

    private static Scanner sc = new Scanner(System.in);

    public Validator() {
    }

    public static String getString(String prompt) {
        while (true) {
            System.out.print(prompt);
            String s = sc.nextLine().trim();
            if (!s.isEmpty()) {
                return s;
            } else {
                System.err.println(Messages.ERROR_EMPTY_INPUT);
            }
        }
    }

    public static String getStringAllowEmpty(String prompt) {
        System.out.print(prompt);
        return sc.nextLine().trim();
    }

    public static int getInt(String prompt, int min, int max) {
        while (true) {
            try {
                System.out.print(prompt);
                int number = Integer.parseInt(sc.nextLine().trim());

                if (number >= min && number <= max) {
                    return number;
                } else {
                    System.err.println("Please input number >= " + min);
                }
            } catch (NumberFormatException e) {
                System.err.println("Please input a valid integer number");
            }
        }
    }

    public static Integer getIntAllowEmpty(String prompt, int min, int max) {
        while (true) {
            System.out.print(prompt);
            String input = sc.nextLine().trim();

            if (input.isEmpty()) {
                return null;
            }

            try {
                int number = Integer.parseInt(input);

                if (number >= min && number <= max) {
                    return number;
                } else {
                    System.err.println("Please input number >= " + min);
                }
            } catch (NumberFormatException e) {
                System.err.println("Please input a valid integer number");
            }
        }
    }

    public static boolean checkAvailability(int value) {
        return value >= 0;
    }

    public static String checkYN(String prompt) {
        while (true) {
            System.out.print(prompt);
            String s = sc.nextLine().trim();
            if (s.equalsIgnoreCase("y") || s.equalsIgnoreCase("n")) {
                return s.toLowerCase();
            } else {
                System.err.println("Please input Y/N:");
            }
        }
    }
}
