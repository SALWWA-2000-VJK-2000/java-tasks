import java.util.Scanner;
import java.util.Stack;

public class UndoActionManager {
    public static void main(String[] args) {
        // 3: Declare variables
        Scanner scanner = new Scanner(System.in);
        Stack<String> actionStack = new Stack<>();

        // 5: Prompt user for number of actions
        System.out.print("Enter the number of actions: ");
        int numberOfActions = scanner.nextInt();
        scanner.nextLine(); // consume newline

        // 6: Validate input
        if (numberOfActions <= 0) {
            System.out.println("Invalid number of actions.");
        } else {
            // 7: Read actions and push to stack
            for (int i = 1; i <= numberOfActions; i++) {
                System.out.print("Enter Action " + i + ": ");
                String action = scanner.nextLine();
                actionStack.push(action);
            }
        }

        // 8: Menu loop
        int choice;
        do {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Add Action");
            System.out.println("2. Undo Last Action");
            System.out.println("3. View Last Action");
            System.out.println("4. Search Action");
            System.out.println("5. Display All Actions");
            System.out.println("6. Display Action Statistics");
            System.out.println("7. Clear All Actions");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1: // Add Action
                    System.out.print("Enter new Action: ");
                    String newAction = scanner.nextLine();
                    actionStack.push(newAction);
                    System.out.println("Action added successfully.");
                    break;

                case 2: // Undo Last Action
                    if (actionStack.isEmpty()) {
                        System.out.println("No actions to undo.");
                    } else {
                        String undoneAction = actionStack.pop();
                        System.out.println("Undone Action: " + undoneAction);
                    }
                    break;

                case 3: // View Last Action
                    if (actionStack.isEmpty()) {
                        System.out.println("No actions available.");
                    } else {
                        System.out.println("Last Action: " + actionStack.peek());
                    }
                    break;

                case 4: // Search Action
                    System.out.print("Enter Action to search: ");
                    String searchAction = scanner.nextLine();
                    int position = actionStack.search(searchAction);
                    if (position == -1) {
                        System.out.println("Action not found.");
                    } else {
                        System.out.println("Action found at position " + position + " from the top.");
                    }
                    break;

                case 5: // Display All Actions
                    if (actionStack.isEmpty()) {
                        System.out.println("No actions available.");
                    } else {
                        System.out.println("\n--- All Actions in Stack ---");
                        for (String action : actionStack) {
                            System.out.println(action);
                        }
                    }
                    break;

                case 6: // Display Action Statistics
                    System.out.println("\n--- Action Statistics ---");
                    System.out.println("Total number of actions: " + actionStack.size());
                    if (!actionStack.isEmpty()) {
                        System.out.println("Most recent action: " + actionStack.peek());
                    } else {
                        System.out.println("Most recent action: None");
                    }
                    System.out.println("Is stack empty? " + actionStack.isEmpty());
                    break;

                case 7: // Clear All Actions
                    actionStack.clear();
                    System.out.println("All actions have been cleared.");
                    break;

                case 8: // Exit
                    System.out.println("Exiting system...");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 8);

        // 14: Close scanner
        scanner.close();
    }
}

