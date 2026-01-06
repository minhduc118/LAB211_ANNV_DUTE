package constants;

public class Messages {

    public static final String MENU_TITLE = "Worker Management";
    public static final String MENU_OPTION_1 = "1. Add Worker";
    public static final String MENU_OPTION_2 = "2. Up salary";
    public static final String MENU_OPTION_3 = "3. Down salary";
    public static final String MENU_OPTION_4 = "4. Display Information salary";
    public static final String MENU_OPTION_5 = "5. Exit";

    public static final String PROMPT_CHOICE = "Enter your choice: ";
    public static final String PROMPT_CODE = "Enter Code: ";
    public static final String PROMPT_NAME = "Enter Name: ";
    public static final String PROMPT_AGE = "Enter Age: ";
    public static final String PROMPT_SALARY = "Enter Salary: ";
    public static final String PROMPT_WORK_LOCATION = "Enter work location: ";
    public static final String PROMPT_AMOUNT = "Enter Salary amount: ";

    public static final String TITLE_ADD_WORKER = "Add Worker";
    public static final String TITLE_UP_DOWN_SALARY = "Up/Down Salary";
    public static final String TITLE_DISPLAY_INFO = "DISPLAY INFORMATION SALARY";

    public static final String SUCCESS_ADD_WORKER = "Worker added successfully!";
    public static final String SUCCESS_INCREASE_SALARY = "Salary increased successfully!";
    public static final String SUCCESS_DECREASE_SALARY = "Salary decreased successfully!";

    public static final String ERROR_INVALID_CHOICE = "Invalid choice. Please select 1-5.";
    public static final String ERROR_EMPTY_INPUT = "Input cannot be empty. Please try again.";
    public static final String ERROR_INVALID_AGE = "Age must be between 18 and 50.";
    public static final String ERROR_INVALID_SALARY = "Salary must be greater than 0.";
    public static final String ERROR_INVALID_AMOUNT = "Amount must be greater than 0.";
    public static final String ERROR_NO_HISTORY = "No salary history available.";

    public static final String TABLE_HEADER = String.format("%-10s %-15s %-5s %-10s %-10s %-15s",
            "Code", "Name", "Age", "Salary", "Status", "Date");

    public static final String EXIT_MESSAGE = "Exiting program. Goodbye!";

    public static final int MIN_AGE = 18;
    public static final int MAX_AGE = 50;
}
