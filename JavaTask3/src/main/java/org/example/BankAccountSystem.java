package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BankAccountSystem {
    public static void main(String[] args) {
        // Create lists to store account information
        List<Integer> accountNumbers = new ArrayList<>();
        List<String> customerNames = new ArrayList<>();
        List<Double> balances = new ArrayList<>();

        // Add 5 customer accounts
        accountNumbers.add(1001); customerNames.add("Salwa"); balances.add(1200.0);
        accountNumbers.add(1002); customerNames.add("Ali"); balances.add(800.0);
        accountNumbers.add(1003); customerNames.add("Sara"); balances.add(1500.0);
        accountNumbers.add(1004); customerNames.add("Omar"); balances.add(500.0);
        accountNumbers.add(1005); customerNames.add("Fatima"); balances.add(2000.0);

        Scanner scanner = new Scanner(System.in);
        int choice;

        // Loop to keep displaying the menu until Exit
        do {
            System.out.println(" Bank Account Management System Menu ");
            System.out.println("1: Display all accounts");
            System.out.println("2: Deposit money");
            System.out.println("3: Withdraw money");
            System.out.println("4: Check account balance");
            System.out.println("5: Display account statistics");
            System.out.println("6: Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    displayAccounts(accountNumbers, customerNames, balances);
                    break;
                case 2:
                    System.out.print("Enter account number: ");
                    int depositAcc = scanner.nextInt();
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    depositMoney(accountNumbers, balances, depositAcc, depositAmount);
                    break;
                case 3:
                    System.out.print("Enter account number: ");
                    int withdrawAcc = scanner.nextInt();
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    withdrawMoney(accountNumbers, balances, withdrawAcc, withdrawAmount);
                    break;
                case 4:
                    System.out.print("Enter account number: ");
                    int checkAcc = scanner.nextInt();
                    checkBalance(accountNumbers, customerNames, balances, checkAcc);
                    break;
                case 5:
                    calculateStatistics(balances);
                    break;
                case 6:
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 6);

        scanner.close();
    }

    // Method to display all accounts
    public static void displayAccounts(List<Integer> accountNumbers, List<String> customerNames, List<Double> balances) {
        System.out.println("Account List ");
        for (int i = 0; i < accountNumbers.size(); i++) {
            System.out.println("Account Number: " + accountNumbers.get(i) +
                    "  Customer Name: " + customerNames.get(i) +
                    "  Balance: " + balances.get(i));
        }
    }

    // Method to deposit money
    public static void depositMoney(List<Integer> accountNumbers, List<Double> balances, int accountNumber, double amount) {
        int index = accountNumbers.indexOf(accountNumber);
        if (index != -1) {
            balances.set(index, balances.get(index) + amount);
            System.out.println("Deposited " + amount + " into account " + accountNumber);
        } else {
            System.out.println("Account not found.");
        }
    }

    // Method to withdraw money
    public static void withdrawMoney(List<Integer> accountNumbers, List<Double> balances, int accountNumber, double amount) {
        int index = accountNumbers.indexOf(accountNumber);
        if (index != -1) {
            if (balances.get(index) >= amount) {
                balances.set(index, balances.get(index) - amount);
                System.out.println("Withdrew " + amount + " from account " + accountNumber);
            } else {
                System.out.println("Insufficient balance.");
            }
        } else {
            System.out.println("Account not found.");
        }
    }

    // Method to check account balance
    public static void checkBalance(List<Integer> accountNumbers, List<String> customerNames, List<Double> balances, int accountNumber) {
        int index = accountNumbers.indexOf(accountNumber);
        if (index != -1) {
            System.out.println("Account Number: " + accountNumber +
                    "Customer Name: " + customerNames.get(index) +
                    " Balance: " + balances.get(index));
        } else {
            System.out.println("Account not found.");
        }
    }

    // Method to calculate statistics
    public static void calculateStatistics(List<Double> balances) {
        double total = 0;
        double highest = balances.get(0);
        double lowest = balances.get(0);

        for (double balance : balances) {
            total += balance;
            if (balance > highest) highest = balance;
            if (balance < lowest) lowest = balance;
        }

        System.out.println("Account Statistics ");
        System.out.println("Total Money in All Accounts: " + total);
        System.out.println("Highest Account Balance: " + highest);
        System.out.println("Lowest Account Balance: " + lowest);
    }
}
