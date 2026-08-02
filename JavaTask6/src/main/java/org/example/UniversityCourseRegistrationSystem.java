package org.example;
import java.util.HashSet;
import java.util.HashMap;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UniversityCourseRegistrationSystem {
    public static void main(String[] args) {
        // 3: Declare variables
        Scanner scanner = new Scanner(System.in);
        HashSet<Integer> studentIds = new HashSet<>();                       // Set for unique student IDs
        HashMap<Integer, HashSet<String>> registrationMap = new HashMap<>(); // Map for student ID → courses

        // 5: Prompt user for number of students
        System.out.print("Enter the number of students: ");
        int numberOfStudents = scanner.nextInt();
        scanner.nextLine();

        // 6: Validate input
        if (numberOfStudents <= 0) {
            System.out.println("Invalid number of students.");
        } else {
            // 7: Read student records
            for (int i = 1; i <= numberOfStudents; i++) {
                System.out.print("Enter Student ID " + i + ": ");
                int studentId = scanner.nextInt();
                scanner.nextLine();

                if (studentIds.contains(studentId)) {
                    System.out.println("Student ID already exists. Record skipped.");
                } else {
                    studentIds.add(studentId);
                    System.out.print("Enter number of courses for this student: ");
                    int courseCount = scanner.nextInt();
                    scanner.nextLine();

                    HashSet<String> courses = new HashSet<>();
                    for (int j = 1; j <= courseCount; j++) {
                        System.out.print("Enter Course " + j + ": ");
                        String courseName = scanner.nextLine();
                        courses.add(courseName);
                    }
                    registrationMap.put(studentId, courses);
                }
            }

            // 8: Menu loop
            int choice;
            do {
                System.out.println("\n--- Menu ---");
                System.out.println("1. Search Student");
                System.out.println("2. Add Course to Student");
                System.out.println("3. Remove Course from Student");
                System.out.println("4. Display All Students");
                System.out.println("5. Display Registration Statistics");
                System.out.println("6. Register New Student");
                System.out.println("7. Display Students in a Course");
                System.out.println("8. Exit");
                System.out.print("Enter your choice: ");
                choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1: // Search Student
                        System.out.print("Enter Student ID to search: ");
                        int searchId = scanner.nextInt();
                        scanner.nextLine();
                        if (registrationMap.containsKey(searchId)) {
                            System.out.println("Courses for Student " + searchId + ": " + registrationMap.get(searchId));
                        } else {
                            System.out.println("Student not found.");
                        }
                        break;

                    case 2: // Add Course
                        System.out.print("Enter Student ID: ");
                        int addId = scanner.nextInt();
                        scanner.nextLine();
                        if (registrationMap.containsKey(addId)) {
                            HashSet<String> courses = registrationMap.get(addId);
                            if (courses.size() >= 6) {
                                System.out.println("Cannot register more than 6 courses.");
                            } else {
                                System.out.print("Enter Course Name: ");
                                String newCourse = scanner.nextLine();
                                if (courses.contains(newCourse)) {
                                    System.out.println("Duplicate course. Not added.");
                                } else {
                                    courses.add(newCourse);
                                    registrationMap.replace(addId, courses);
                                    System.out.println("Course added successfully.");
                                }
                            }
                        } else {
                            System.out.println("Student not found.");
                        }
                        break;

                    case 3: // Remove Course
                        System.out.print("Enter Student ID: ");
                        int removeId = scanner.nextInt();
                        scanner.nextLine();
                        if (registrationMap.containsKey(removeId)) {
                            System.out.print("Enter Course Name to remove: ");
                            String removeCourse = scanner.nextLine();
                            HashSet<String> courses = registrationMap.get(removeId);
                            if (courses.remove(removeCourse)) {
                                System.out.println("Course removed successfully.");
                            } else {
                                System.out.println("Course not found for this student.");
                            }
                        } else {
                            System.out.println("Student not found.");
                        }
                        break;

                    case 4: // Display All Students
                        System.out.println("\n--- All Students ---");
                        List<Integer> sortedIds = new ArrayList<>(studentIds);
                        Collections.sort(sortedIds);
                        for (Integer id : sortedIds) {
                            System.out.println("Student ID: " + id + ", Courses: " + registrationMap.get(id));
                        }
                        break;

                    case 5: // Registration Statistics
                        int totalStudents = registrationMap.size();
                        int totalCourses = 0;
                        int maxCourses = Integer.MIN_VALUE;
                        int minCourses = Integer.MAX_VALUE;
                        int studentMax = -1, studentMin = -1;

                        for (Integer id : registrationMap.keySet()) {
                            int courseSize = registrationMap.get(id).size();
                            totalCourses += courseSize;
                            if (courseSize > maxCourses) {
                                maxCourses = courseSize;
                                studentMax = id;
                            }
                            if (courseSize < minCourses) {
                                minCourses = courseSize;
                                studentMin = id;
                            }
                        }

                        // Calculate average courses per student using normal check
                        double averageCourses;
                        if (totalStudents > 0) {
                            averageCourses = (double) totalCourses / totalStudents;
                        } else {
                            averageCourses = 0;
                        }


                        System.out.println("\n--- Registration Statistics ---");
                        System.out.println("Total Students: " + totalStudents);
                        System.out.println("Total Course Registrations: " + totalCourses);
                        System.out.println("Student with highest courses: " + studentMax + " (" + maxCourses + ")");
                        System.out.println("Student with lowest courses: " + studentMin + " (" + minCourses + ")");
                        System.out.println("Average courses per student: " + averageCourses);
                        break;

                    case 6: // Register New Student
                        System.out.print("Enter new Student ID: ");
                        int newId = scanner.nextInt();
                        scanner.nextLine();
                        if (studentIds.contains(newId)) {
                            System.out.println("Student ID already exists.");
                        } else {
                            studentIds.add(newId);
                            System.out.print("Enter number of courses: ");
                            int newCourseCount = scanner.nextInt();
                            scanner.nextLine();
                            HashSet<String> newCourses = new HashSet<>();
                            for (int j = 1; j <= newCourseCount; j++) {
                                System.out.print("Enter Course " + j + ": ");
                                String courseName = scanner.nextLine();
                                newCourses.add(courseName);
                            }
                            registrationMap.put(newId, newCourses);
                            System.out.println("New student registered successfully.");
                        }
                        break;

                    case 7: // Display Students in a Course
                        System.out.print("Enter Course Name: ");
                        String courseSearch = scanner.nextLine();
                        System.out.println("Students registered in " + courseSearch + ":");
                        for (Integer id : registrationMap.keySet()) {
                            if (registrationMap.get(id).contains(courseSearch)) {
                                System.out.println("Student ID: " + id);
                            }
                        }
                        break;

                    case 8: // Exit
                        System.out.println("Exiting system...");
                        break;

                    default:
                        System.out.println("Invalid choice. Try again.");
                }
            } while (choice != 8);

            // Final summary
            System.out.println("\n--- Final Registration Summary ---");
            for (Integer id : registrationMap.keySet()) {
                System.out.println("Student ID: " + id + ", Courses: " + registrationMap.get(id));
            }
        }

        // 15: Close scanner
        scanner.close();
    }
}