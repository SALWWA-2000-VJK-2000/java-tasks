package org.example;
import java.util.HashSet;
import java.util.HashMap;
import java.util.Scanner;

public class CourseEnrollmentSystem {

        public static void main(String[] args) {
        // 3: Declare variables
        Scanner scanner = new Scanner(System.in);
        HashSet<Integer> studentIds = new HashSet<>();             // Set for unique IDs
        HashMap<Integer, String> enrollmentMap = new HashMap<>();  // Map for ID → Course

        // 5: Prompt user for number of students
        System.out.print("Enter the number of students: ");
        int numberOfStudents = scanner.nextInt();
        scanner.nextLine();

        // 6: Validate input
        if (numberOfStudents <= 0) {
            System.out.println("Invalid number of students.");
        } else {
            // 7: Read student ID and course name in a loop
            for (int i = 1; i <= numberOfStudents; i++) {
                System.out.print("Enter Student ID " + i + ": ");
                int studentId = scanner.nextInt();
                scanner.nextLine();

                if (studentIds.contains(studentId)) {
                    System.out.println("Student ID already exists. Record not added.");

                } else {
                    System.out.print("Enter Course Name: ");
                    String courseName = scanner.nextLine();
                    studentIds.add(studentId);
                    enrollmentMap.put(studentId, courseName);
                }
            }

            // 8: Prompt for student ID to update
            System.out.print("Enter a Student ID to update course: ");
            int updateId = scanner.nextInt();
            scanner.nextLine();

            // 9 & 10: Update course if ID exists
            if (enrollmentMap.containsKey(updateId)) {
                System.out.print("Enter new course name: ");
                String newCourse = scanner.nextLine();
                enrollmentMap.replace(updateId, newCourse);
                System.out.println("Course updated successfully.");
            } else {
                System.out.println("Student ID not found.");
            }

            // 11: Classify enrollment
            int uniqueCount = enrollmentMap.size();
            String classification;
            if (uniqueCount < 5) {
                classification = "Small Enrollment";
            } else if (uniqueCount <= 15) {
                classification = "Medium Enrollment";
            } else {
                classification = "Large Enrollment";
            }

            // 12: Display summary
            System.out.println("\n--- Enrollment Summary ---");
            System.out.println("Total student records entered: " + numberOfStudents);
            System.out.println("Total unique students: " + uniqueCount);

            System.out.println("All Student IDs:");
            for (Integer id : studentIds) {
                System.out.println("ID: " + id);
            }

            System.out.println("All Student IDs with Courses:");
            for (Integer id : enrollmentMap.keySet()) {
                System.out.println("ID: " + id + ", Course: " + enrollmentMap.get(id));
            }

            System.out.println("Enrollment classification: " + classification);
        }

        // 14: Close scanner
        scanner.close();
    }
    }

