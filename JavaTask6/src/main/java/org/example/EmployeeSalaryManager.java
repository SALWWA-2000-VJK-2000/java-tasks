package org.example;
import java.util.HashMap;
import java.util.Scanner;
public class EmployeeSalaryManager {

        public static void main(String[] args) {
            // 3: Declare variables
            Scanner scanner = new Scanner(System.in);
            HashMap<Integer, Double> employeeSalaries = new HashMap<>();

            // 5: Prompt user for number of employees
            System.out.print("Enter the number of employees: ");
            int numberOfEmployees = scanner.nextInt();

            // 6: Validate input
            if (numberOfEmployees <= 0) {
                System.out.println("Invalid number of employees.");
            } else {
                // 7: Read employee ID and salary in a loop
                for (int i = 1; i <= numberOfEmployees; i++) {
                    System.out.print("Enter Employee ID " + i + ": ");
                    int employeeId = scanner.nextInt();

                    if (employeeSalaries.containsKey(employeeId)) {
                        System.out.println("Employee ID already exists. Record not added.");
                        i--; // repeat this iteration
                    } else {
                        System.out.print("Enter Salary: ");
                        double salary = scanner.nextDouble();
                        employeeSalaries.put(employeeId, salary);
                    }
                }

                // 8: Menu loop
                int choice;
                do {
                    System.out.println("\n--- Menu ---");
                    System.out.println("1. Add Employee");
                    System.out.println("2. Search Employee");
                    System.out.println("3. Update Salary");
                    System.out.println("4. Remove Employee");
                    System.out.println("5. Display All Employees");
                    System.out.println("6. Display Salary Statistics");
                    System.out.println("7. Exit");
                    System.out.print("Enter your choice: ");
                    choice = scanner.nextInt();

                    switch (choice) {
                        case 1: // Add Employee
                            System.out.print("Enter new Employee ID: ");
                            int newId = scanner.nextInt();
                            if (employeeSalaries.containsKey(newId)) {
                                System.out.println("Employee ID already exists. Record not added.");
                            } else {
                                System.out.print("Enter Salary: ");
                                double newSalary = scanner.nextDouble();
                                employeeSalaries.put(newId, newSalary);
                                System.out.println("Employee added successfully.");
                            }
                            break;

                        case 2: // Search Employee
                            System.out.print("Enter Employee ID to search: ");
                            int searchId = scanner.nextInt();
                            if (employeeSalaries.containsKey(searchId)) {
                                System.out.println("Employee Found. Salary: " + employeeSalaries.get(searchId));
                            } else {
                                System.out.println("Employee not found.");
                            }
                            break;

                        case 3: // Update Salary
                            System.out.print("Enter Employee ID to update: ");
                            int updateId = scanner.nextInt();
                            if (employeeSalaries.containsKey(updateId)) {
                                System.out.print("Enter new Salary: ");
                                double updatedSalary = scanner.nextDouble();
                                employeeSalaries.replace(updateId, updatedSalary);
                                System.out.println("Salary updated successfully.");
                            } else {
                                System.out.println("Employee not found.");
                            }
                            break;

                        case 4: // Remove Employee
                            System.out.print("Enter Employee ID to remove: ");
                            int removeId = scanner.nextInt();
                            if (employeeSalaries.containsKey(removeId)) {
                                employeeSalaries.remove(removeId);
                                System.out.println("Employee removed successfully.");
                            } else {
                                System.out.println("Employee not found.");
                            }
                            break;

                        case 5: // Display All Employees
                            System.out.println("\n--- All Employees ---");
                            for (Integer id : employeeSalaries.keySet()) {
                                System.out.println("Employee ID: " + id + ", Salary: " + employeeSalaries.get(id));
                            }
                            break;

                        case 6: // Display Salary Statistics
                            if (employeeSalaries.isEmpty()) {
                                System.out.println("No employee records available.");
                            } else {
                                double highest = Double.MIN_VALUE;
                                double lowest = Double.MAX_VALUE;
                                double total = 0;

                                for (double salary : employeeSalaries.values()) {
                                    if (salary > highest) highest = salary;
                                    if (salary < lowest) lowest = salary;
                                    total += salary;
                                }

                                double average;
                                if (employeeSalaries.size() > 0) {
                                    average = total / employeeSalaries.size();
                                } else {
                                    average = 0;
                                }

                                System.out.println("\n--- Salary Statistics ---");
                                System.out.println("Highest Salary: " + highest);
                                System.out.println("Lowest Salary: " + lowest);
                                System.out.println("Average Salary: " + average);
                                System.out.println("Total Payroll: " + total);
                            }
                            break;

                        case 7: // Exit
                            System.out.println("Exiting system...");
                            break;

                        default:
                            System.out.println("Invalid choice. Try again.");
                    }
                } while (choice != 7);
            }

            // 14: Close scanner
            scanner.close();
        }
    }



