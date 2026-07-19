package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentListManager {
    static void  main(){
        List<String> students = new ArrayList<>();

        /*for (int i = 1; i < 11; i++) {
            students.add(IO.readln("Enter name " + i+ " :"));
        }*/
        // Add at least 10 student names to the list
        students.add("Ali");
        students.add("Sara");
        students.add("Omar");
        students.add("Fatima");
        students.add("Hassan");
        students.add("Layla");
        students.add("Ahmed");
        students.add("Noor");
        students.add("Yusuf");
        students.add("Salma");

        // Display all student names using a loop
        System.out.println("Student List:");
        for (String student : students) {
            System.out.println(student);
        }

        // Display the total number of students
        System.out.println("Total Students: " + students.size());

        // Display the first student in the list
        System.out.println("First Student: " + students.get(0));

        // Display the last student in the list
        System.out.println("Last Student: " + students.get(students.size() - 1));


        // Create Scanner object for user input
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a student name to check: ");
        String name = scanner.nextLine();

        if (students.contains(name)) {
            System.out.println(name + " exists in the list.");
        } else {
            System.out.println(name + " does not exist in the list.");
        }
        // Remove a student from the list (example: removing Omar)
        String removeName = "Omar";
        students.remove(removeName);
        System.out.println(removeName + " has been removed from the list.");

        // Display the updated list after removal
        System.out.println("Updated Student List:");
        for (String student : students) {
            System.out.println(student);
        }
        scanner.close();
    }
}
