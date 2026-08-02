package org.example;
import java.util.HashMap;
import java.util.Scanner;

public class StudentAttendanceManager {
    public static void main(String[] args) {
        // 3: Declare variables
        Scanner scanner = new Scanner(System.in);
        HashMap<Integer, Integer> attendanceMap = new HashMap<>();

        // 5: Prompt user for number of student records
        System.out.print("Enter the number of student records: ");
        int numberOfStudents = scanner.nextInt();

        // 6: Validate input
        if (numberOfStudents <= 0) {
            System.out.println("Invalid number of students.");
        } else {
            // 7: Read student ID and attendance days in a loop
            for (int i = 1; i <= numberOfStudents; i++) {
                System.out.print("Enter Student ID " + i + ": ");
                int studentId = scanner.nextInt();

                if (attendanceMap.containsKey(studentId)) {
                    System.out.println("Student ID already exists. Record not added.");
                    i--; // repeat this iteration
                } else {
                    System.out.print("Enter number of attended days: ");
                    int attendedDays = scanner.nextInt();
                    attendanceMap.put(studentId, attendedDays);
                }
            }

            // 8: Menu loop
            int choice;
            do {
                System.out.println("\n--- Menu ---");
                System.out.println("1. Add Student Record");
                System.out.println("2. Search Student Attendance");
                System.out.println("3. Update Attendance");
                System.out.println("4. Remove Student Record");
                System.out.println("5. Display All Attendance Records");
                System.out.println("6. Display Attendance Statistics");
                System.out.println("7. Exit");
                System.out.print("Enter your choice: ");
                choice = scanner.nextInt();

                switch (choice) {
                    case 1: // Add Student Record
                        System.out.print("Enter new Student ID: ");
                        int newId = scanner.nextInt();
                        if (attendanceMap.containsKey(newId)) {
                            System.out.println("Student ID already exists. Record not added.");
                        } else {
                            System.out.print("Enter number of attended days: ");
                            int newDays = scanner.nextInt();
                            attendanceMap.put(newId, newDays);
                            System.out.println("Student record added successfully.");
                        }
                        break;

                    case 2: // Search Student Attendance
                        System.out.print("Enter Student ID to search: ");
                        int searchId = scanner.nextInt();
                        if (attendanceMap.containsKey(searchId)) {
                            System.out.println("Student Found. Attendance Days: " + attendanceMap.get(searchId));
                        } else {
                            System.out.println("Student not found.");
                        }
                        break;

                    case 3: // Update Attendance
                        System.out.print("Enter Student ID to update: ");
                        int updateId = scanner.nextInt();
                        if (attendanceMap.containsKey(updateId)) {
                            System.out.print("Enter new number of attended days: ");
                            int updatedDays = scanner.nextInt();
                            attendanceMap.replace(updateId, updatedDays);
                            System.out.println("Attendance updated successfully.");
                        } else {
                            System.out.println("Student not found.");
                        }
                        break;

                    case 4: // Remove Student Record
                        System.out.print("Enter Student ID to remove: ");
                        int removeId = scanner.nextInt();
                        if (attendanceMap.containsKey(removeId)) {
                            attendanceMap.remove(removeId);
                            System.out.println("Student record removed successfully.");
                        } else {
                            System.out.println("Student not found.");
                        }
                        break;

                    case 5: // Display All Attendance Records
                        System.out.println("\n--- All Attendance Records ---");
                        for (Integer id : attendanceMap.keySet()) {
                            System.out.println("Student ID: " + id + ", Attended Days: " + attendanceMap.get(id));
                        }
                        break;

                    case 6: // Display Attendance Statistics
                        if (attendanceMap.isEmpty()) {
                            System.out.println("No attendance records available.");
                        } else {
                            int totalStudents = attendanceMap.size();
                            int totalDays = 0;
                            int highestDays = Integer.MIN_VALUE;
                            int lowestDays = Integer.MAX_VALUE;
                            int studentMax = -1, studentMin = -1;

                            for (var entry : attendanceMap.entrySet()) {
                                int days = entry.getValue();
                                totalDays += days;
                                if (days > highestDays) {
                                    highestDays = days;
                                    studentMax = entry.getKey();
                                }
                                if (days < lowestDays) {
                                    lowestDays = days;
                                    studentMin = entry.getKey();
                                }
                            }

                            double averageDays;
                            if (totalStudents > 0) {
                                averageDays = (double) totalDays / totalStudents;
                            } else {
                                averageDays = 0;
                            }

                            System.out.println("\n--- Attendance Statistics ---");
                            System.out.println("Total Students: " + totalStudents);
                            System.out.println("Total Attendance Days: " + totalDays);
                            System.out.println("Average Attendance: " + averageDays);
                            System.out.println("Student with highest attendance: " + studentMax + " (" + highestDays + ")");
                            System.out.println("Student with lowest attendance: " + studentMin + " (" + lowestDays + ")");
                        }
                        break;

                    case 7: 
                        System.out.println("Exiting system...");
                        break;

                    default:
                        System.out.println("Invalid choice. Try again.");
                }
            } while (choice != 7);
        }

        // 14: Close scanner
        scanner.close();
    }
}