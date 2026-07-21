package org.example;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class EmployeeSalary {
    public static void main() {
        ArrayList<String> employeeNames = new ArrayList<>();
        ArrayList<Integer> employeeIds = new ArrayList<>();
        ArrayList<Double> employeeSalaries = new ArrayList<>();

        // add employees
        employeeIds.add(1001); employeeNames.add("Ali"); employeeSalaries.add(850.0);
        employeeIds.add(1002); employeeNames.add("Sara"); employeeSalaries.add(1200.0);
        employeeIds.add(1003); employeeNames.add("Ahmed"); employeeSalaries.add(1500.0);
        employeeIds.add(1004); employeeNames.add("Omar"); employeeSalaries.add(700.0);
        employeeIds.add(1005); employeeNames.add("Fatima"); employeeSalaries.add(950.0);
        employeeIds.add(1006); employeeNames.add("Salwa"); employeeSalaries.add(1100.0);
        employeeIds.add(1007); employeeNames.add("Reem"); employeeSalaries.add(400.0);
        employeeIds.add(1008); employeeNames.add("Tariq"); employeeSalaries.add(500.0);
        employeeIds.add(1009); employeeNames.add("Hassan"); employeeSalaries.add(650.0);
        employeeIds.add(1010); employeeNames.add("Mona"); employeeSalaries.add(1000.0);

        Scanner scanner = new Scanner(System.in);

        //Display Employee Information
        System.out.println("Employee Information:");
        for (int i = 0; i < employeeNames.size(); i++) {
            System.out.println("Employee " + i + ": ");
            System.out.println("ID: " + employeeIds.get(i));
            System.out.println("Name: " + employeeNames.get(i));
            System.out.println("Salary: " + employeeSalaries.get(i));
        }

        //Calculate Salary Statistics
        int totalEmployees = employeeNames.size();
        double totalSalary = 0;
        double highest = employeeSalaries.get(0);
        double lowest = employeeSalaries.get(0);

        for (double salary : employeeSalaries) {
            if (salary > highest) {
                highest = salary;
            }
            if (salary < lowest) {
                lowest = salary;
            }
        }
        double average = (double) totalSalary / totalEmployees;
        System.out.println("Total Employees: " + totalEmployees);
        System.out.println("Total Salary: " + totalSalary);
        System.out.println("Average Salary: " + average);
        System.out.println("Highest Salary: " + highest);
        System.out.println("Lowest Salary: " + lowest);

        //Salary Category Analysis
        int high = 0;
        int medium = 0;
        int low = 0;

        for (double salary : employeeSalaries) {
            if (salary > 1000) {
                high++;
            } else if (salary >= 500) {
                medium++;
            } else {
                low++;
            }
        }
        System.out.println("High Salary Employees: " + high);
        System.out.println("Medium Salary Employees: " + medium);
        System.out.println("Low Salary Employees: " + low);

        //Search Employee System
        System.out.print("Enter employee ID to search: ");
        int searchId = scanner.nextInt();
        if (employeeIds.contains(searchId)) {
            int index = employeeIds.indexOf(searchId);
            System.out.println("Employee found.");
            System.out.println("Name: " + employeeNames.get(index));
            System.out.println("Salary: " + employeeSalaries.get(index));
            System.out.println("Position: " + index);
        } else {
            System.out.println("Employee not found.");
        }

        //Update Employee Salary
        System.out.print("Enter Employee Index: ");
        int updateIndex = scanner.nextInt();
        if (updateIndex >= 0 && updateIndex < employeeSalaries.size()) {
            System.out.print("Enter New Salary: ");
            double newSalary = scanner.nextDouble();
            employeeSalaries.set(updateIndex, newSalary);
            System.out.println("Salary updated successfully.");
            System.out.println("Updated Employee: " + employeeNames.get(updateIndex) + " - " + employeeSalaries.get(updateIndex));
        } else {
            System.out.println("Invalid index.");
        }

        //Remove Employee
        System.out.print("Remove Employee Index: ");
        int removeIndex = scanner.nextInt();
        if (removeIndex >= 0 && removeIndex < employeeNames.size()) {
            employeeNames.remove(removeIndex);
            employeeIds.remove(removeIndex);
            employeeSalaries.remove(removeIndex);
            System.out.println("Employee removed successfully.");
        } else {
            System.out.println("Invalid index.");
        }

        //Sorting Employees
        ArrayList<Double> sortedAsc = new ArrayList<>(employeeSalaries);
        ArrayList<Double> sortedDesc = new ArrayList<>(employeeSalaries);
        Collections.sort(sortedAsc);
        Collections.sort(sortedDesc, Collections.reverseOrder());
        System.out.println("Salaries Ascending: " + sortedAsc);
        System.out.println("Salaries Descending: " + sortedDesc);

        //Employee Salary Bonus Calculation
        System.out.println("Salary Bonus Report:");
        for (int i = 0; i < employeeNames.size(); i++) {
            double salary = employeeSalaries.get(i);
            double bonus;
            if (salary >= 1000) bonus = salary * 0.10;
            else if (salary >= 500) bonus = salary * 0.05;
            else bonus = salary * 0.02;
            double finalSalary = salary + bonus;
            System.out.println(employeeNames.get(i) + " - Salary: " + salary + ", Bonus: " + bonus + ", Final Salary: " + finalSalary);
        }


        scanner.close();
    }
}

