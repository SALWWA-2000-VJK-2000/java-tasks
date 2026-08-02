package org.example;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class CourseEnrollmentSet {
    static void main(String[] args) {
        //  3: Declare variables
        Scanner scanner = new Scanner(System.in);
        Set<String> courseName = new HashSet<>();
        int totalEntered;

        //  5:
        System.out.print("Enter the  number of courses to register: ");
        totalEntered = scanner.nextInt();

        //  6: Validate input
        if (totalEntered <= 0) {
            System.out.println("Invalid number of courses." );
        } else {
            //  7: Read names in a loop
            for (int i = 1; i <= totalEntered; i++) {
                System.out.print("Enter courses name " + i + ": ");
                String id = scanner.next();
                boolean added = courseName.add(id);

                if (!added) {
                    System.out.println("Course already exists. Duplicate entries are not allowed."  );
                }
            }
            // 8: REMOVE
            System.out.println("Enter a courses name to remove : ");
            String removedCourse = scanner.next();
            // 9: checking
            // 10: Display
            if(courseName.remove(removedCourse)){
                System.out.println("Course removed successfully.");
            }else {
                System.out.println("Course not found.");
            }

            //  11: Classify registration
            int uniqueCount = courseName.size();
            String classification;
            if (uniqueCount < 4) {
                classification = " Small Course Catalog ";
            } else if (uniqueCount <= 8) {
                classification = "Medium Course Catalog ";
            } else {
                classification = "Large  Course Catalog  ";
            }

            //  12: Display results
            System.out.println("\n--- Course Catalog Report ---");
            System.out.println("Total course entered: " + totalEntered);
            System.out.println("Total unique courses remaining  : " + uniqueCount);
            System.out.println("All remaining course names: " + courseName);
            System.out.println("Removal result : "+ removedCourse);
            System.out.println("Course Catalog classification: " + classification);

            //  14: Close scanner
            scanner.close();

        }
    }


}
