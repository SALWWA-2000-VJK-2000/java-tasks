import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class StudentRegistrationManager {
    static void main() {
        // 3: Declare variables
        Scanner scanner = new Scanner(System.in);
        Queue<String> registrationQueue = new LinkedList<>(); // students waiting
        Stack<String> registrationStack = new Stack<>();      // completed registrations

        // 5: Prompt user for number of students
        System.out.print("Enter the number of students waiting for registration: ");
        int numberOfStudents = scanner.nextInt();
        scanner.nextLine();

        // 6: Validate input
        if (numberOfStudents <= 0) {
            System.out.println("Invalid number of students.");
        } else {
            // 7: Read student names and add to queue
            for (int i = 1; i <= numberOfStudents; i++) {
                System.out.print("Enter Student Name " + i + ": ");
                String studentName = scanner.nextLine();
                registrationQueue.add(studentName);
            }
        }

        // 8: Menu loop
        int choice;
        do {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Add Student to Queue");
            System.out.println("2. Process Student Registration");
            System.out.println("3. View Next Student");
            System.out.println("4. Undo Last Registration");
            System.out.println("5. Search Student");
            System.out.println("6. Display Waiting Students");
            System.out.println("7. Display Registered Students");
            System.out.println("8. Display Statistics");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1: // Add Student to Queue
                    System.out.print("Enter new Student Name: ");
                    String newStudent = scanner.nextLine();
                    registrationQueue.add(newStudent);
                    System.out.println("Student added to registration queue successfully.");
                    break;

                case 2: // Process Student Registration
                    if (registrationQueue.isEmpty()) {
                        System.out.println("No students waiting for registration.");
                    } else {
                        String student = registrationQueue.remove(); // remove from queue
                        registrationStack.push(student);             // push to stack
                        System.out.println("Student registration completed: " + student);
                    }
                    break;

                case 3: // View Next Student
                    if (registrationQueue.isEmpty()) {
                        System.out.println("No students in the queue.");
                    } else {
                        System.out.println("Next Student: " + registrationQueue.element());
                    }
                    break;

                case 4: // Undo Last Registration
                    if (registrationStack.isEmpty()) {
                        System.out.println("No registrations to undo.");
                    } else {
                        String undoneStudent = registrationStack.pop();
                        System.out.println("Undone Registration: " + undoneStudent);
                    }
                    break;

                case 5: // Search Student
                    System.out.print("Enter Student Name to search: ");
                    String searchName = scanner.nextLine();
                    if (registrationQueue.contains(searchName)) {
                        System.out.println("Student is waiting for registration.");
                    } else if (registrationStack.contains(searchName)) {
                        System.out.println("Student is already registered.");
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;

                case 6: // Display Waiting Students
                    if (registrationQueue.isEmpty()) {
                        System.out.println("No waiting students.");
                    } else {
                        System.out.println("\n--- Waiting Students ---");
                        for (String student : registrationQueue) {
                            System.out.println(student);
                        }
                    }
                    break;

                case 7: // Display Registered Students
                    if (registrationStack.isEmpty()) {
                        System.out.println("No registered students.");
                    } else {
                        System.out.println("\n--- Registered Students ---");
                        for (String student : registrationStack) {
                            System.out.println(student);
                        }
                    }
                    break;

                case 8: // Display Statistics
                    System.out.println("\n--- System Statistics ---");
                    System.out.println("Total waiting students: " + registrationQueue.size());
                    System.out.println("Total registered students: " + registrationStack.size());
                    if (!registrationQueue.isEmpty()) {
                        System.out.println("Next student waiting: " + registrationQueue.peek());
                    } else {
                        System.out.println("Next student waiting: None");
                    }
                    if (!registrationStack.isEmpty()) {
                        System.out.println("Last registered student: " + registrationStack.peek());
                    } else {
                        System.out.println("Last registered student: None");
                    }
                    System.out.println("Is queue empty? " + registrationQueue.isEmpty());
                    System.out.println("Is stack empty? " + registrationStack.isEmpty());
                    break;

                case 9: // Exit
                    System.out.println("Exiting system...");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 9);

        // 15: Close scanner
        scanner.close();
    }
}
