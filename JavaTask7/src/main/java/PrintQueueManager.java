import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class PrintQueueManager {
    static void main() {
                // 3: Declare variables
                Scanner scanner = new Scanner(System.in);
                Queue<String> printQueue  = new LinkedList<>();

                // 5: Prompt user for number of print jobs
                System.out.print("Enter the number of print jobs: ");
                int numberOfJobs = scanner.nextInt();
                scanner.nextLine(); // consume newline

                // 6: Validate input
                if (numberOfJobs <= 0) {
                    System.out.println("Invalid number of print jobs.");
                } else {
                    // 7: Read print job names and add to queue
                    for (int i = 1; i <= numberOfJobs; i++) {
                        System.out.print("Enter Print Job " + i + ": ");
                        String jobName = scanner.nextLine();
                        printQueue.offer(jobName); // add job to queue
                    }
                }
                // 8: Menu loop
                int choice;
                do {
                    System.out.println("\n--- Menu ---");
                    System.out.println("1. Add Print Job ");
                    System.out.println("2. Process Next Print Job  ");
                    System.out.println("3. View Next Print Job");
                    System.out.println("4. Search Print Job");
                    System.out.println("5. Remove Print Job  ");
                    System.out.println("6. Display All Print Jobs ");
                    System.out.println("7. Display Queue Statistics ");
                    System.out.println("8. Exit  ");
                    System.out.print("Enter your choice: ");
                    choice = scanner.nextInt();
                    scanner.nextLine();

                    switch (choice) {
                        case 1: // Add print job
                            System.out.print("Enter new print job name : ");
                            String newPrintJop = scanner.nextLine();
                            printQueue.offer(newPrintJop);
                            System.out.println("Print job added successfully." );
                            break;

                        case 2: // Process Next Print Job
                            if (printQueue.isEmpty()) {
                                System.out.println("No print jobs in the queue."  );
                            } else {
                                String nextPrint  = printQueue.poll();
                                System.out.println(" processed print job: " + nextPrint);
                            }
                            break;

                        case 3: //View Next Print Job
                            if (printQueue.isEmpty()) {
                                System.out.println("No print jobs in the queue.");
                            } else {
                                System.out.println("  Next Print Job: " + printQueue.peek());
                            }
                            break;

                        case 4: // Search Print Job
                            System.out.print("Enter Print Job to search: ");
                            String searchPrintJop = scanner.nextLine();
                            if (!printQueue.contains(searchPrintJop)) {
                                System.out.println("Print Job not found.");
                            } else {
                                System.out.println("Print Job '" + searchPrintJop +"' found ");
                            }
                            break;

                        case 5: // Remove Print Job

                            System.out.print("Enter Print Job to remove: ");
                            String removePrintJop = scanner.nextLine();
                            if (!printQueue.contains(removePrintJop)) {
                                System.out.println("Print Job not found.");
                            } else {
                                System.out.println("Next Print Job: " + printQueue.remove(removePrintJop));
                            }
                            break;

                            case 6: // Display All Print Jobs
                            if (printQueue.isEmpty()) {
                                System.out.println("No print jobs in the queue.");
                            } else {
                                System.out.println("\n--- All printQueue in Queue ---");
                                for (String print : printQueue) {
                                    System.out.println(print);
                                }
                            }
                            break;

                        case 7: // Display Queue Statistics
                            System.out.println("\n--- Queue Statistics ---");
                            System.out.println("Total number of print jobs : " + printQueue.size());

                            if (!printQueue.isEmpty()) {
                                // First customer
                                System.out.println("Next print job : " + printQueue.peek());
                            } else {
                                System.out.println("Next print job in the queue: None");
                            }

                            System.out.println("Is queue empty? " + printQueue.isEmpty());
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

