import java.util.ArrayList;
import java.util.Scanner;

public class PasswordStrengthChecker {
    static void main() {
        // 3: Declare variables
        Scanner scanner = new Scanner(System.in);
        String password=""; //4: a String variable to store the password entered

        // 5: Prompt user for password
        System.out.print("Enter the password: ");
        password = scanner.nextLine();

        // 6: Validate input
        if (password.length() <= 0) {
            System.out.println("Invalid password");
        } else {
            // 7: Analyze the password immediately
            int uppercase = 0, lowercase = 0, digits = 0, special = 0;
            for (int i = 0; i < password.length(); i++) {
                char ch = password.charAt(i);
                if (Character.isUpperCase(ch)) uppercase++;
                else if (Character.isLowerCase(ch)) lowercase++;
                else if (Character.isDigit(ch)) digits++;
                else special++;
            }

            System.out.println("\n--- Initial Password Security Information ---");
            System.out.println("Password length: " + password.length());
            System.out.println("Uppercase letters: " + uppercase);
            System.out.println("Lowercase letters: " + lowercase);
            System.out.println("Digits: " + digits);
            System.out.println("Special characters: " + special);

            if (password.length() >= 8 && uppercase > 0 && lowercase > 0 && digits > 0 && special > 0) {
                System.out.println("Strength: Strong Password");
            } else if (password.length() >= 6 && ((uppercase > 0 && lowercase > 0) || (digits > 0 && lowercase > 0))) {
                System.out.println("Strength: Medium Password");
            } else {
                System.out.println("Strength: Weak Password");
            }
        }

        // 8: Menu loop
        int choice;
        do {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Enter Password");
            System.out.println("2. Check Password Length");
            System.out.println("3. Analyze Password Characters");
            System.out.println("4. Check Password Strength");
            System.out.println("5. Convert Password Format");
            System.out.println("6. Display Password Report");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1: // Enter Password
                    System.out.print("Enter new password: ");
                    password = scanner.nextLine();
                    System.out.println("Password saved successfully.");
                    break;

                case 2: // Check Password Length
                    System.out.println("Password length: " + password.length());
                    if (password.length() < 8) {
                        System.out.println("Password is too short.");
                    } else {
                        System.out.println("Password length is acceptable.");
                    }
                    break;

                case 3: // Analyze Password Characters
                    int uppercase = 0, lowercase = 0, digits = 0, special = 0;
                    for (int i = 0; i < password.length(); i++) {
                        char ch = password.charAt(i);
                        if (Character.isUpperCase(ch)) uppercase++;
                        else if (Character.isLowerCase(ch)) lowercase++;
                        else if (Character.isDigit(ch)) digits++;
                        else special++;
                    }
                    System.out.println("Uppercase letters: " + uppercase);
                    System.out.println("Lowercase letters: " + lowercase);
                    System.out.println("Digits: " + digits);
                    System.out.println("Special characters: " + special);
                    break;

                case 4: // Check Password Strength
                    boolean hasUpper = false, hasLower = false, hasDigit = false, hasSpecial = false;
                    for (int i = 0; i < password.length(); i++) {
                        char ch = password.charAt(i);
                        if (Character.isUpperCase(ch)) hasUpper = true;
                        else if (Character.isLowerCase(ch)) hasLower = true;
                        else if (Character.isDigit(ch)) hasDigit = true;
                        else hasSpecial = true;
                    }
                    if (password.length() >= 8 && hasUpper && hasLower && hasDigit && hasSpecial) {
                        System.out.println("Strong Password");
                    } else if (password.length() >= 6 && ((hasUpper && hasLower) || (hasDigit && hasLower))) {
                        System.out.println("Medium Password");
                    } else {
                        System.out.println("Weak Password");
                    }
                    break;

                case 5: // Convert Password Format
                    System.out.println("Uppercase: " + password.toUpperCase());
                    System.out.println("Lowercase: " + password.toLowerCase());
                    break;

                case 6: // Display Password Report
                    int upper = 0, lower = 0, digit = 0, spec = 0;
                    for (int i = 0; i < password.length(); i++) {
                        char ch = password.charAt(i);
                        if (Character.isUpperCase(ch)) upper++;
                        else if (Character.isLowerCase(ch)) lower++;
                        else if (Character.isDigit(ch)) digit++;
                        else spec++;
                    }

                    String strength;
                    if (password.length() >= 8 && upper > 0 && lower > 0 && digit > 0 && spec > 0) {
                        strength = "Strong Password";
                    } else if (password.length() >= 6 && ((upper > 0 && lower > 0) || (digit > 0 && lower > 0))) {
                        strength = "Medium Password";
                    } else {
                        strength = "Weak Password";
                    }

                    System.out.println("\n--- Password Report ---");
                    System.out.println("Password length: " + password.length());
                    if (password.length() > 0) {
                        System.out.println("First character: " + password.charAt(0));
                        System.out.println("Last character: " + password.charAt(password.length() - 1));
                    }
                    System.out.println("Uppercase letters: " + upper);
                    System.out.println("Lowercase letters: " + lower);
                    System.out.println("Digits: " + digit);
                    System.out.println("Special characters: " + spec);
                    System.out.println("Password strength level: " + strength);
                    break;

                case 7: // Exit
                    System.out.println("Exiting system...");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 7);

        // 15: Close scanner
        scanner.close();
    }
}

