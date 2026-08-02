package org.example;


import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class EmployeeDirectoryMap {
    static void main(String[] args) {
        //  3: Declare variables
        Scanner scanner = new Scanner(System.in);
        HashMap<Integer, String> employeeMap = new HashMap<>();
        int totalEntered;

        //  5:
        System.out.print("Enter the number of employees  to register: ");
        totalEntered = scanner.nextInt();

        //  6: Validate input
        if (totalEntered <= 0) {
            System.out.println("Invalid number of employees.");
        } else {
            //  7: Read id & name in a loop
            // 7: Read id & name in a loop
            for (int i = 1; i <= totalEntered; i++) {
                System.out.print("Enter employee ID " + i + ": ");
                int employeeId = scanner.nextInt();
                scanner.nextLine();

                if (employeeMap.containsKey(employeeId)) {
                    System.out.println("Employee ID already exists. Please enter a unique ID.");
                    i--;
                } else {
                    System.out.print("Enter Employee Name: ");
                    String employeeName = scanner.nextLine();
                    employeeMap.put(employeeId, employeeName);
                }
            }
                // 8: Search

            System.out.print("Enter an employee ID to search for: ");
            int searchId = scanner.nextInt();

            if (employeeMap.containsKey(searchId)) {
                System.out.println("Employee Found: " + employeeMap.get(searchId));
            } else {
                System.out.println("Employee ID not found.");
            }

                // 11: Classify registration
                int uniqueCount = employeeMap.size();
                String classification;

                if (uniqueCount < 5) {
                    classification = "Small Company";
                } else if (uniqueCount <= 10) {
                    classification = "Medium Company";
                } else {
                    classification = "Large Company";
            }

                //  12: Display results
                System.out.println("\n--- Company Report ---");
                System.out.println("Total employee records entered: " + totalEntered);
                System.out.println("Total unique employees : " + uniqueCount);
                System.out.println("All employee IDs and names: " + employeeMap);
                System.out.println("Search result: " + searchId);
                System.out.println("Company classification: " + classification);

                //  14: Close scanner
                scanner.close();

            }
        }
    }



