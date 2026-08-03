import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class HospitalPatientManager {
    static void main() {
        // 3: Declare variables
        Scanner scanner = new Scanner(System.in);
        Queue<String> waitingQueue = new LinkedList<>(); // patients waiting for treatment
        Stack<String> treatmentStack = new Stack<>();    // completed treatments

        // 5: Prompt user for number of patients
        System.out.print("Enter the number of patients waiting: ");
        int numberOfPatients = scanner.nextInt();
        scanner.nextLine();

        // 6: Validate input
        if (numberOfPatients <= 0) {
            System.out.println("Invalid number of patients.");
        } else {
            // 7: Read patient names and add to queue
            // 7: Read patient names and add to queue
            for (int i = 1; i <= numberOfPatients; i++) {
                System.out.print("Enter Patient Name " + i + ": ");
                String patientName = scanner.nextLine();

                if (waitingQueue.contains(patientName) || treatmentStack.contains(patientName)) {
                    System.out.println("Duplicate patient record. Not added.");
                } else {
                    waitingQueue.offer(patientName); // add using offer()
                }
            }


            // 8: Menu loop
            int choice;
            do {
                System.out.println("\n--- Menu ---");
                System.out.println("1. Add Patient");
                System.out.println("2. Treat Patient");
                System.out.println("3. View Next Patient");
                System.out.println("4. Undo Last Treatment");
                System.out.println("5. Search Patient");
                System.out.println("6. Display Waiting Patients");
                System.out.println("7. Display Treated Patients");
                System.out.println("8. Display Hospital Statistics");
                System.out.println("9. Exit");
                System.out.print("Enter your choice: ");
                choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1: // Add Patient
                        System.out.print("Enter new Patient Name: ");
                        String newPatient = scanner.nextLine();

                        if (waitingQueue.contains(newPatient) || treatmentStack.contains(newPatient)) {
                            System.out.println("Duplicate patient record. Patient not added.");
                        } else {
                            waitingQueue.offer(newPatient);
                            System.out.println("Patient added successfully.");
                        }
                        break;


                    case 2: // Treat Patient
                        if (waitingQueue.isEmpty()) {
                            System.out.println("No patients waiting for treatment.");
                        } else {
                            String treatedPatient = waitingQueue.poll(); // remove from queue
                            treatmentStack.push(treatedPatient);         // push to stack
                            System.out.println("Patient treatment completed successfully: " + treatedPatient);
                        }
                        break;

                    case 3: // View Next Patient
                        if (waitingQueue.isEmpty()) {
                            System.out.println("No patients available.");
                        } else {
                            System.out.println("Next Patient: " + waitingQueue.peek());
                        }
                        break;

                    case 4: // Undo Last Treatment
                        if (treatmentStack.isEmpty()) {
                            System.out.println("No completed treatments available.");
                        } else {
                            String undonePatient = treatmentStack.pop();
                            System.out.println("Treatment undone for patient: " + undonePatient);
                        }
                        break;

                    case 5: // Search Patient
                        System.out.print("Enter Patient Name to search: ");
                        String searchName = scanner.nextLine();
                        if (waitingQueue.contains(searchName)) {
                            System.out.println("Patient is waiting for treatment.");
                        } else if (treatmentStack.contains(searchName)) {
                            System.out.println("Patient treatment completed.");
                        } else {
                            System.out.println("Patient not found.");
                        }
                        break;

                    case 6: // Display Waiting Patients
                        if (waitingQueue.isEmpty()) {
                            System.out.println("No waiting patients.");
                        } else {
                            System.out.println("\n--- Waiting Patients ---");
                            for (String patient : waitingQueue) {
                                System.out.println(patient);
                            }
                        }
                        break;

                    case 7: // Display Treated Patients
                        if (treatmentStack.isEmpty()) {
                            System.out.println("No treated patients.");
                        } else {
                            System.out.println("\n--- Treated Patients ---");
                            for (String patient : treatmentStack) {
                                System.out.println(patient);
                            }
                        }
                        break;

                    case 8: // Display Hospital Statistics
                        System.out.println("\n--- Hospital Statistics ---");
                        System.out.println("Total waiting patients: " + waitingQueue.size());
                        System.out.println("Total treated patients: " + treatmentStack.size());
                        if (!waitingQueue.isEmpty()) {
                            System.out.println("Next patient waiting: " + waitingQueue.peek());
                        } else {
                            System.out.println("Next patient waiting: None");
                        }
                        if (!treatmentStack.isEmpty()) {
                            System.out.println("Last treated patient: " + treatmentStack.peek());
                        } else {
                            System.out.println("Last treated patient: None");
                        }
                        System.out.println("Is waiting queue empty? " + waitingQueue.isEmpty());
                        System.out.println("Is treatment stack empty? " + treatmentStack.isEmpty());
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
