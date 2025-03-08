import java.util.Scanner;

public class InputHelper {

    public static String getRegExString(Scanner pipe, String prompt, String regEx) {
        String result = "";
        boolean validInput = false;

        do {
            System.out.print(prompt + " (must match pattern: " + regEx + "): "); // Display the prompt and pattern
            if (pipe.hasNextLine()) { // Check if input is available
                result = pipe.nextLine().trim(); // Read the input and trim whitespace
                if (result.matches(regEx)) { // Check if the input matches the RegEx pattern
                    validInput = true; // Valid input received
                } else {
                    System.out.println("Invalid input: \"" + result + "\". Please try again.");
                }
            }
        } while (!validInput);

        return result;
    }

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String userString = getRegExString(console, "Enter a string", "^[A-Za-z0-9]{5,10}$");
        System.out.println("You entered: " + userString);
    }
}
