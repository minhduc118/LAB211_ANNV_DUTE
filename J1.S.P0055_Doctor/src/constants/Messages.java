package constants;

public class Messages {

    // Menu
    public static final String MENU_TITLE = "========= Doctor Management =========";
    public static final String MENU_OPTION_1 = "1. Add Doctor";
    public static final String MENU_OPTION_2 = "2. Update Doctor";
    public static final String MENU_OPTION_3 = "3. Delete Doctor";
    public static final String MENU_OPTION_4 = "4. Search Doctor";
    public static final String MENU_OPTION_5 = "5. Exit";

    // Prompts
    public static final String PROMPT_CHOICE = "Enter your choice: ";
    public static final String PROMPT_CODE = "Enter Code: ";
    public static final String PROMPT_NAME = "Enter Name: ";
    public static final String PROMPT_SPECIALIZATION = "Enter Specialization: ";
    public static final String PROMPT_AVAILABILITY = "Enter Availability: ";
    public static final String PROMPT_SEARCH = "Enter text: ";
    public static final String PROMPT_CONFIRM_DELETE = "Are you sure you want to delete? (Y/N): ";

    // Section Titles
    public static final String TITLE_ADD_DOCTOR = "---------- Add Doctor ----------";
    public static final String TITLE_UPDATE_DOCTOR = "---------- Update Doctor -------";
    public static final String TITLE_DELETE_DOCTOR = "---------- Delete Doctor -------";
    public static final String TITLE_SEARCH_DOCTOR = "---------- Search Doctor --------";
    public static final String TITLE_RESULT = "---------- Result ------------";

    // Success Messages
    public static final String SUCCESS_ADD_DOCTOR = "Doctor added successfully!";
    public static final String SUCCESS_UPDATE_DOCTOR = "Doctor updated successfully!";
    public static final String SUCCESS_DELETE_DOCTOR = "Doctor deleted successfully!";

    // Error Messages
    public static final String ERROR_INVALID_CHOICE = "Invalid choice. Please select 1-5.";
    public static final String ERROR_EMPTY_INPUT = "Input cannot be empty. Please try again.";
    public static final String ERROR_INVALID_AVAILABILITY = "Availability must be >= 0.";
    public static final String ERROR_CODE_NOT_EXIST = "Doctor code does not exist";
    public static final String ERROR_NO_RESULTS = "No doctors found matching the search criteria.";

    // Table Header
    public static final String TABLE_HEADER = String.format("%-10s %-15s %-20s %-10s",
            "Code", "Name", "Specialization", "Availability");

    // Exit Message
    public static final String EXIT_MESSAGE = "Exiting program. Goodbye!";

    // Validation
    public static final int MIN_AVAILABILITY = 0;
    public static final int MAX_AVAILABILITY = Integer.MAX_VALUE;
}
