package org.example;
import java.util.HashMap;
import java.util.Scanner;

public class StudentGradesMap {
         static void main(String[] args) {
            // 3: Declare variables
            Scanner scanner = new Scanner(System.in);
            HashMap<Integer, Double> studentGrades = new HashMap<>();

            // 5: Prompt user for number of students
            System.out.print("Enter the number of students: ");
            int numberOfStudents = scanner.nextInt();

            // 6: Validate input
            if (numberOfStudents <= 0) {
                System.out.println("Invalid number of students.");
            } else {
                // 7: Read student ID and grade in a loop
                for (int i = 1; i <= numberOfStudents; i++) {
                    System.out.print("Enter Student ID " + i + ": ");
                    int studentId = scanner.nextInt();

                    if (studentGrades.containsKey(studentId)) {
                        System.out.println("Student ID already exists. Record not added.");
                    } else {
                        System.out.print("Enter Grade: ");
                        double grade = scanner.nextDouble();
                        studentGrades.put(studentId, grade);
                    }
                }

                // 8: Prompt for student ID to update
                System.out.print("Enter a Student ID to update grade: ");
                int updateId = scanner.nextInt();

                // 9 & 10: Update grade if ID exists
                if (studentGrades.containsKey(updateId)) {
                    System.out.print("Enter new grade: ");
                    double newGrade = scanner.nextDouble();
                    studentGrades.replace(updateId, newGrade);
                    System.out.println("Grade updated successfully.");
                } else {
                    System.out.println("Student ID not found.");
                }

                // 11: Calculate average grade
                double sum = 0;
                for (double grade : studentGrades.values()) {
                    sum += grade;
                }
                double averageGrade = sum / studentGrades.size();

                // 12: Classify performance
                String performance;
                if (averageGrade < 60) {
                    performance = "Needs Improvement";
                } else if (averageGrade <= 84) {
                    performance = "Good Performance";
                } else {
                    performance = "Excellent Performance";
                }

                // 13: Display results
                System.out.println("\n--- Student Grades Summary ---");
                System.out.println("Total student records: " + studentGrades.size());
                System.out.println("All student IDs and grades:");
                for (Integer id : studentGrades.keySet()) {
                    System.out.println("ID: " + id + ", Grade: " + studentGrades.get(id));
                }
                System.out.println("Average grade: " + averageGrade);
                System.out.println("Class performance classification: " + performance);
            }

            // 14: Close scanner
            scanner.close();
        }
    }



