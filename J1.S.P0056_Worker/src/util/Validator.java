package util;

import java.util.Scanner;

public class Validator {

    private static Scanner sc = new Scanner(System.in);

    public Validator() {
    }

    public static double getDouble(String input, double min, double max) {
        while (true) {
            try {
                System.out.print(input);
                double number = Double.parseDouble(sc.nextLine());

                if (number >= min && number <= max) {
                    return number;
                } else {
                    System.err.println("Please input number more than " + min);
                }
            } catch (NumberFormatException e) {
                System.err.println("Please input double number");
            }
        }
    }

    public static String getString(String input) {
        while (true) {
            System.out.print(input);
            String s = sc.nextLine();
            if (!s.isEmpty()) {
                return s;
            } else {
                System.err.println("Please input string");
            }
        }
    }

    public static int getInt(String input, int min, int max) {
        while (true) {
            try {
                System.out.print(input);
                int number = Integer.parseInt(sc.nextLine());

                if (number >= min && number <= max) {
                    return number;
                } else {
                    System.err.println("Please input number in range [" + min + ", " + max + "]");
                }
            } catch (NumberFormatException e) {
                System.err.println("Please input integer number");
            }
        }
    }

    public static String checkYN(String input) {
        while (true) {
            System.out.print(input);
            String s = sc.nextLine();
            if (s.equalsIgnoreCase("y") || s.equalsIgnoreCase("n")) {
                return s;
            } else {
                System.err.println("Please input Y/N:");
            }
        }
    }
}
