package view;

import java.util.List;
import constants.Messages;
import model.Candidate;

public final class MenuView {

    private MenuView() {
    }

    public static void displayMenu() {
        System.out.println("\n" + Messages.MENU_TITLE);
        System.out.println(Messages.MENU_OPTION_1);
        System.out.println(Messages.MENU_OPTION_2);
        System.out.println(Messages.MENU_OPTION_3);
        System.out.println(Messages.MENU_OPTION_4);
        System.out.println(Messages.MENU_OPTION_5);
    }

    public static void displayTitle(String title) {
        System.out.println("\n" + title);
    }

    public static void displaySuccess(String message) {
        System.out.println(message);
    }

    public static void displayError(String message) {
        System.err.println(message);
    }

    public static void displaySearchResults(List<Candidate> results) {
        if (results.isEmpty()) {
            System.out.println(Messages.ERROR_NO_CANDIDATES);
        } else {
            System.out.println("\nSearch Results:");
            for (Candidate candidate : results) {
                System.out.println(candidate);
            }
        }
    }

    public static void displayCandidateList(String title, List<Candidate> candidates) {
        System.out.println("\n" + title);
        for (Candidate candidate : candidates) {
            System.out.println("  " + candidate.getFullName());
        }
    }
}
