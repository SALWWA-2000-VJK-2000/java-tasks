package org.example;
//Task 353: Product Inventory Set System

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ProductInventorySet {
     static void main(String[] args) {
        //  3: Declare variables
            Scanner scanner = new Scanner(System.in);
            Set<String> productName = new HashSet<>();
            int totalEntered;

            //  5:
            System.out.print("Enter the number of products to register: ");
            totalEntered = scanner.nextInt();

            //  6: Validate input
            if (totalEntered <= 0) {
                System.out.println("Invalid number of products." );
            } else {
                //  7: Read names in a loop
                for (int i = 1; i <= totalEntered; i++) {
                    System.out.print("Enter product name " + i + ": ");
                    String id = scanner.next();
                    boolean added = productName.add(id);

                    if (!added) {
                        System.out.println("Product already exists. Duplicate entries are not allowed."  );
                    }
                }
                // 8: Search
                System.out.println("Enter a product name to search for: ");
                String searchName = scanner.next();
                // 9: checking if set contains the product
                // 10: Display
                if(productName.contains(searchName)){
                    System.out.println("Product: "+searchName+ "  found in inventory.");
                }else {
                    System.out.println("Product '" + searchName + "' not found in inventory.");
                }

                //  11: Classify registration
                int uniqueCount = productName.size();
                String classification;
                if (uniqueCount < 5) {
                    classification = "Small Inventory";
                } else if (uniqueCount <= 10) {
                    classification = "Medium Inventory";
                } else {
                    classification = "Large Inventory";
                }

                //  12: Display results
                System.out.println("\n--- Inventory Report ---");
                System.out.println("Total product entered: " + totalEntered);
                System.out.println("Total unique product name: " + uniqueCount);
                System.out.println("All unique product name: " + productName);
                System.out.println("Inventory classification: " + classification);

                //  14: Close scanner
                scanner.close();

            }
        }
    }


