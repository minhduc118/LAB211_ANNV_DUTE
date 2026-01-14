package constants;

public class Messages {

    public static final String MENU_TITLE = "CANDIDATE MANAGEMENT";
    public static final String MENU_OPTION_1 = "1. Experience";
    public static final String MENU_OPTION_2 = "2. Fresher";
    public static final String MENU_OPTION_3 = "3. Internship";
    public static final String MENU_OPTION_4 = "4. Searching";
    public static final String MENU_OPTION_5 = "5. Exit";

    public static final String PROMPT_CHOICE = "Enter your choice: ";
    public static final String PROMPT_ID = "Enter ID: ";
    public static final String PROMPT_FIRST_NAME = "Enter First Name: ";
    public static final String PROMPT_LAST_NAME = "Enter Last Name: ";
    public static final String PROMPT_BIRTH_YEAR = "Enter Birth Year (1900 - Current Year): ";
    public static final String PROMPT_ADDRESS = "Enter Address: ";
    public static final String PROMPT_PHONE = "Enter Phone Number: ";
    public static final String PROMPT_EMAIL = "Enter Email: ";
    public static final String PROMPT_CONTINUE = "Do you want to continue (Y/N): ";

    public static final String PROMPT_YEAR_EXPERIENCE = "Enter year of experience: ";
    public static final String PROMPT_PROFESSIONAL_SKILL = "Enter professional skill: ";

    public static final String PROMPT_GRADUATION_DATE = "Enter graduation date: ";
    public static final String PROMPT_GRADUATION_RANK = "Enter graduation rank (Excellence/Good/Fair/Poor): ";

    public static final String PROMPT_MAJOR = "Enter major: ";
    public static final String PROMPT_SEMESTER = "Enter semester: ";
    public static final String PROMPT_UNIVERSITY = "Enter university: ";

    public static final String PROMPT_SEARCH_NAME = "Enter candidate name (First name or Last name): ";
    public static final String PROMPT_SEARCH_TYPE = "Enter type of candidate (0-Experience, 1-Fresher, 2-Internship): ";

    public static final String TITLE_ADD_EXPERIENCE = "=== ADD EXPERIENCE CANDIDATE ===";
    public static final String TITLE_ADD_FRESHER = "=== ADD FRESHER CANDIDATE ===";
    public static final String TITLE_ADD_INTERNSHIP = "=== ADD INTERNSHIP CANDIDATE ===";
    public static final String TITLE_SEARCH = "=== SEARCH CANDIDATE ===";
    public static final String TITLE_EXPERIENCE_LIST = "Experience Candidates:";
    public static final String TITLE_FRESHER_LIST = "Fresher Candidates:";
    public static final String TITLE_INTERNSHIP_LIST = "Internship Candidates:";

    public static final String SUCCESS_CREATE = "Create success.";

    public static final String ERROR_ID_EXISTS = "ID already exists.";
    public static final String ERROR_EMPTY_INPUT = "Input cannot be empty.";
    public static final String ERROR_INVALID_NUMBER = "Please input a valid number.";
    public static final String ERROR_INVALID_RANGE = "Please input number in range [%d, %d].";
    public static final String ERROR_INVALID_PHONE = "Phone must be at least 10 digits.";
    public static final String ERROR_INVALID_EMAIL = "Email format: <account>@<domain>.";
    public static final String ERROR_INVALID_RANK = "Please input: Excellence, Good, Fair, or Poor.";
    public static final String ERROR_INVALID_YN = "Please input Y or N.";
    public static final String ERROR_EXPERIENCE_GREATER_THAN_AGE = "Experience must be less than age.";
    public static final String ERROR_NO_CANDIDATES = "No candidates found.";

    public static final String EXIT_MESSAGE = "Exiting program. Goodbye!";

    public static final int MIN_BIRTH_YEAR = 1900;
    public static final int MIN_EXPERIENCE = 0;
    public static final int MAX_EXPERIENCE = 100;
    public static final int MIN_CANDIDATE_TYPE = 0;
    public static final int MAX_CANDIDATE_TYPE = 2;

    public static final String PHONE_PATTERN = "^\\d{10,}$";
    public static final String EMAIL_PATTERN = "^[A-Za-z0-9.+_%-]+@[A-Za-z.-]+\\.[A-Za-z]{2,4}$";
}
