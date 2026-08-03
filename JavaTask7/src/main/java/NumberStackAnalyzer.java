import java.util.Scanner;
import java.util.Stack;

public class NumberStackAnalyzer {
    static void main() {
        // 3: Declare variables
        Scanner scanner = new Scanner(System.in);
        Stack<Integer> valueStack = new Stack<>();

        // 5: Prompt user for number of values
        System.out.print("Enter the number of values: ");
        int numberOfValues = scanner.nextInt();
        scanner.nextLine(); // consume newline

        // 6: Validate input
        if (numberOfValues <= 0) {
            System.out.println("Invalid number of values.");
        } else {
            // 7: Read values and push to stack
            for (int i = 1; i <= numberOfValues; i++) {
                System.out.print("Enter values " + i + ": ");
                Integer values = scanner.nextInt();
                valueStack.push(values);
            }
        }
// 8: Menu loop
        int choice;
        do {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Add Number");
            System.out.println("2. Remove Top Number ");
            System.out.println("3. View Top Number");
            System.out.println("4. Display All Numbers ");
            System.out.println("5.  Analyze Numbers ");
            System.out.println("6.Exit ");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1: // Add Value
                    System.out.print("Enter new Value: ");
                    Integer newValue = scanner.nextInt();
                    valueStack.push(newValue);
                    System.out.println("Value added successfully.");
                    break;

                case 2: // Remove Top Number
                    if (valueStack.isEmpty()) {
                        System.out.println("Stack is empty.");
                    } else {
                        Integer removeValue= valueStack.pop();
                        System.out.println("Remove Value: " + removeValue);
                    }
                    break;

                case 3: // View Top Number
                    if (valueStack.isEmpty()) {
                        System.out.println("Stack is empty."  );
                    } else {
                        System.out.println("Top Value: " + valueStack.peek());
                    }
                    break;

                case 4: // Display All Numbers
                    if (valueStack.isEmpty()) {
                        System.out.println("Stack is empty."  );
                    } else {
                        System.out.println("\n--- All Number in Stack ---");
                        for (Integer value : valueStack) {
                            System.out.println(value);
                        }
                    }
                    break;

                case 5: // Analyze Numbers
                    if (valueStack.isEmpty()) {
                        System.out.println("No numbers available to analyze.");
                    } else {
                        int totalElements = valueStack.size();
                        int sum = 0;
                        double average = 0.0;
                        int largest = Integer.MIN_VALUE;
                        int smallest = Integer.MAX_VALUE;
                        int evenCount = 0, oddCount = 0;
                        int positiveCount = 0, negativeCount = 0, zeroCount = 0;

                        // Loop through all numbers in the stack
                        for (int num : valueStack) {
                            sum += num;

                            if (num > largest) largest = num;
                            if (num < smallest) smallest = num;

                            if (num % 2 == 0) evenCount++;
                            else oddCount++;

                            if (num > 0) positiveCount++;
                            else if (num < 0) negativeCount++;
                            else zeroCount++;
                        }

                        average = (double) sum / totalElements;

                        // Display results
                        System.out.println("\n--- Number Analysis ---");
                        System.out.println("Total number of elements: " + totalElements);
                        System.out.println("Sum of all numbers: " + sum);
                        System.out.println("Average of all numbers: " + average);
                        System.out.println("Largest number: " + largest);
                        System.out.println("Smallest number: " + smallest);
                        System.out.println("Total even numbers: " + evenCount);
                        System.out.println("Total odd numbers: " + oddCount);
                        System.out.println("Total positive numbers: " + positiveCount);
                        System.out.println("Total negative numbers: " + negativeCount);
                        System.out.println("Total zeros: " + zeroCount);
                    }
                    break;

                case 6: // Exit
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
