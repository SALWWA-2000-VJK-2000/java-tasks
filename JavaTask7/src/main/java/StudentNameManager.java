import java.util.ArrayList;
import java.util.Scanner;

 class StudentNameManager {
     static void main(String[] args) {
        // 3: Declare variables
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> studentNames = new ArrayList<>();

        // 5: Prompt user for number of students
        System.out.print("Enter the number of students: ");
        int numberOfStudents = scanner.nextInt();
        scanner.nextLine();

        // 6: Validate input
        if (numberOfStudents <= 0) {
            System.out.println("Invalid number of students.");
        } else {
            // 7: Read student names
            for (int i = 0; i < numberOfStudents; i++) {
                System.out.print("Enter Student Name " + (i + 1) + ": ");
                studentNames.add(scanner.nextLine());
            }
        }

        // 8: Menu loop
        int choice;
        do {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Add Student Name");
            System.out.println("2. Search Student Name");
            System.out.println("3. Update Student Name");
            System.out.println("4. Display All Student Names");
            System.out.println("5. Analyze Names");
            System.out.println("6. Compare Two Names");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1: // Add Student Name
                    System.out.print("Enter new Student Name: ");
                    String newName = scanner.nextLine();
                    if (studentNames.contains(newName)) {
                        System.out.println("Student name already exists.");
                    } else {
                        studentNames.add(newName);
                        System.out.println("Student name added successfully.");
                    }
                    break;

                case 2: // Search Student Name
                    System.out.print("Enter Student Name to search: ");
                    String searchName = scanner.nextLine();
                    if (studentNames.contains(searchName)) {
                        System.out.println("Student found.");
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;

                case 3: // Update Student Name
                    System.out.print("Enter existing Student Name: ");
                    String oldName = scanner.nextLine();
                    System.out.print("Enter new Student Name: ");
                    String updatedName = scanner.nextLine();
                    if (studentNames.contains(oldName)) {
                        int index = studentNames.indexOf(oldName);
                        studentNames.set(index, updatedName);
                        System.out.println("Student name updated successfully.");
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;

                case 4: // Display All Student Names
                    System.out.println("\n--- All Student Names ---");
                    for (int i = 0; i < studentNames.size(); i++) {
                        System.out.println((i + 1) + ". " + studentNames.get(i));
                    }
                    break;

                case 5: // Analyze Names
                    if (studentNames.isEmpty()) {
                        System.out.println("No student records available.");
                    } else {
                        String longest = studentNames.get(0);
                        String shortest = studentNames.get(0);
                        int totalChars = 0;
                        int startsWithA = 0;
                        int endsWitha = 0;

                        for (String name : studentNames) {
                            totalChars += name.length();
                            if (name.length() > longest.length()) longest = name;
                            if (name.length() < shortest.length()) shortest = name;
                            if (name.startsWith("A")) startsWithA++;
                            if (name.endsWith("a")) endsWitha++;

                            // Demonstrating charAt and substring
                            System.out.println("First letter of " + name + ": " + name.charAt(0));
                            if (name.length() >= 3) {
                                System.out.println("First 3 letters: " + name.substring(0, 3));
                            }
                            System.out.println("Uppercase: " + name.toUpperCase());
                            System.out.println("Lowercase: " + name.toLowerCase());
                        }

                        double averageLength = (double) totalChars / studentNames.size();

                        System.out.println("\n--- Name Analysis ---");
                        System.out.println("Total number of students: " + studentNames.size());
                        System.out.println("Longest student name: " + longest);
                        System.out.println("Shortest student name: " + shortest);
                        System.out.println("Total characters in all names: " + totalChars);
                        System.out.println("Average name length: " + averageLength);
                        System.out.println("Number of names starting with 'A': " + startsWithA);
                        System.out.println("Number of names ending with 'a': " + endsWitha);
                    }
                    break;


                case 6: // Compare Two Names
                    System.out.print("Enter first Student Name: ");
                    String name1 = scanner.nextLine();
                    System.out.print("Enter second Student Name: ");
                    String name2 = scanner.nextLine();

                    System.out.println("\n--- Name Comparison ---");
                    System.out.println("equals(): " + name1.equals(name2));
                    System.out.println("(): " + name1.equalsIgnoreCase(name2));
                    System.out.println("compareTo(): " + name1.compareTo(name2));
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
