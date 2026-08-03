import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class CustomerQueueManager {
    static void main() {
        // 3: Declare variables
        Scanner scanner = new Scanner(System.in);
        Queue<String> customerQueue = new LinkedList<>();

        // 5: Prompt user for number of customers
        System.out.print("Enter the number of customers: ");
        int numberOfCustomer = scanner.nextInt();
        scanner.nextLine(); // consume newline

        // 6: Validate input
        if (numberOfCustomer <= 0) {
            System.out.println("Invalid number of customers.");
        } else {
            // 7: Read values and push to stack
            for (int i = 1; i <= numberOfCustomer; i++) {
                System.out.print("Enter customer name " + i + ": ");
                String values = scanner.next();
                customerQueue.offer(values);
            }
        }
        // 8: Menu loop
        int choice;
        do {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Add Customer");
            System.out.println("2. Serve Customer ");
            System.out.println("3. View Next Customer ");
            System.out.println("4. Search Customer   ");
            System.out.println("5. Display All Customers ");
            System.out.println("6. Display Queue Statistics");
            System.out.println("7. Exit  ");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1: // Add Customer
                    System.out.print("Enter new customer: ");
                    String newCustomer = scanner.nextLine();
                    customerQueue.offer(newCustomer);
                    System.out.println("Action added successfully.");
                    break;

                case 2: // Serve Customer
                    if (customerQueue.isEmpty()) {
                        System.out.println("No customers in the queue.");
                    } else {
                        String serveCustomer  = customerQueue.poll();
                        System.out.println("served customer's name: " + serveCustomer);
                    }
                    break;

                case 3: //View Next Customer
                    if (customerQueue.isEmpty()) {
                        System.out.println("No customers in the queue.");
                    } else {
                        System.out.println(" First customer: " + customerQueue.peek());
                    }
                    break;

                case 4: // Search Customer
                    System.out.print("Enter Customer to search: ");
                    String searchCustomer = scanner.nextLine();
                    if (!customerQueue.contains(searchCustomer)) {
                        System.out.println("Customer not found.");
                    } else {
                        System.out.println("Customer '" + searchCustomer +"' found ");
                    }
                    break;

                case 5: // Display All Customers
                    if (customerQueue.isEmpty()) {
                        System.out.println("No customer available.");
                    } else {
                        System.out.println("\n--- All customerQueue in Stack ---");
                        for (String customer : customerQueue) {
                            System.out.println(customer);
                        }
                    }
                    break;

                case 6: // Display Queue Statistics
                    System.out.println("\n--- Queue Statistics ---");
                    System.out.println("Total number of customers: " + customerQueue.size());

                    if (!customerQueue.isEmpty()) {
                        // First customer
                        System.out.println("First customer in the queue: " + customerQueue.peek());

                        // Last customer (using LinkedList methods)
                        String lastCustomer = ((LinkedList<String>) customerQueue).getLast();
                        System.out.println("Last customer in the queue: " + lastCustomer);
                    } else {
                        System.out.println("First customer in the queue: None");
                        System.out.println("Last customer in the queue: None");
                    }

                    System.out.println("Is queue empty? " + customerQueue.isEmpty());
                    break;

                case 7: // Exit
                    System.out.println("Exiting system...");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 7);

        // 14: Close scanner
        scanner.close();
    }
}

