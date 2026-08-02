package org.example;
import java.util.*;
import java.util.Scanner;
public class StudentSetManager {
     static void main(String[] args) {
        //  3: Declare variables
         Scanner scanner = new Scanner(System.in);
            Set<String> studentIds = new HashSet<>();
            int totalEntered;

            //  5:
            System.out.print("Enter the number of student IDs to register: ");
            totalEntered = scanner.nextInt();

            //  6: Validate input
            if (totalEntered <= 0) {
                System.out.println("Invalid number of students.");
            } else {
                //  7: Read IDs in a loop
                for (int i = 1; i <= totalEntered; i++) {
                    System.out.print("Enter student ID " + i + ": ");
                    String id = scanner.next();
                    boolean added = studentIds.add(id);

                    if (!added) {
                        System.out.println("Duplicate ID detected. ID was not added.");
                    }
                }
                //  8: Classify registration
                int uniqueCount = studentIds.size();
                String classification;
                if (uniqueCount < 5) {
                    classification = "Small Registration";
                } else if (uniqueCount <= 10) {
                    classification = "Medium Registration";
                } else {
                    classification = "Large Registration";
                }
                //  9: Display results
                System.out.println("\n--- Registration Report ---");
                System.out.println("Total IDs entered: " + totalEntered);
                System.out.println("Total unique student IDs: " + uniqueCount);
                System.out.println("All unique student IDs: " + studentIds);
                System.out.println("Registration classification: " + classification);

                //  11: Close scanner
                scanner.close();
            }



    }
}
