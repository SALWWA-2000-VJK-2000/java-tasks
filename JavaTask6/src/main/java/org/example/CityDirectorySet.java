package org.example;


import java.util.Scanner;

import java.util.TreeSet;

public class CityDirectorySet {
    static void main(String[] args) {
        //Task 355: City Directory Set System

        //  3: Declare variables
        Scanner scanner = new Scanner(System.in);
        TreeSet<String>cityName = new TreeSet<>();
        int totalEntered;
        //  5:
        System.out.print("Enter the number of  cities to register: ");
        totalEntered = scanner.nextInt();

        //  6: Validate input
        if (totalEntered <= 0) {
            System.out.println("Invalid number  of cities." );
        } else {
            //  7: Read names in a loop
            for (int i = 1; i <= totalEntered; i++) {
                System.out.print("Enter city name " + i + ": ");
                String id = scanner.next();
                boolean added = cityName.add(id);

                if (!added) {
                    System.out.println("City already exists. Duplicate entries are not allowed." );
                }
            }
            // 8: Search
            System.out.println("Enter a city name to search for: ");
            String searchName = scanner.next();
            // 9: checking if set contains the city
            // 10: Display
            if(cityName.contains(searchName)){
                System.out.println("City found in the directory.");
            }else {
                System.out.println("City not found in the directory.");
            }

            //  11: Classify registration
            int uniqueCount = cityName.size();
            String classification;
            if (uniqueCount < 5) {
                classification = "Small Directory";
            } else if (uniqueCount <= 10) {
                classification = "Medium Directory";
            } else {
                classification = "Large Directory";
            }

            //  12: Display results
            System.out.println("\n--- Directory Report ---");
            System.out.println("Total cities entered  " + totalEntered);
            System.out.println("Total unique cities  : " + uniqueCount);
            System.out.println("All cities in alphabetical order : " + cityName);
            System.out.println("Inventory classification: " + classification);

            //  14: Close scanner
            scanner.close();

        }
    }
}



