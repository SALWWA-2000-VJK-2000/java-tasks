package org.example;

import java.util.Scanner;

public class CsvLineParser {
    static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter line record : ");
        String record = scanner.nextLine().strip();
        // Split on commas
        String[] parts = record.split(",");
        if (parts.length != 3) {
            System.out.println("Invalid record.");
            scanner.close();
            return;
        }
        // Trim each field
        String name = parts[0].trim();
        //String ageText = parts[1].trim();
        String city = parts[2].trim();

        //convert the age to an int with Integer.parseInt
        int age= Integer.parseInt(parts[1].trim());

        // Classify age
        String ageGroup;
        if (age < 18) {
            ageGroup = "Minor";
        } else if (age <= 64) {
            ageGroup = "Adult";
        } else {
            ageGroup = "Senior";
        }

        // Print results
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("City: " + city);
        System.out.println("Age Group: " + ageGroup);

        //  Close scanner
        scanner.close();
    }
}