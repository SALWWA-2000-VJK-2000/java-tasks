package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BankTransaction {
    static void main() {
        ArrayList<Integer> accountNumbers = new ArrayList<>();
        ArrayList<String> customerNames = new ArrayList<>();
        ArrayList<Double> balances = new ArrayList<>();
        ArrayList<String> accountTypes = new ArrayList<>();
        ArrayList<String> accountStatus = new ArrayList<>();

        //1. Create Account Data Lists
        accountNumbers.add(10001); customerNames.add("Ali"); balances.add(2500.0); accountTypes.add("Savings"); accountStatus.add("Active");
        accountNumbers.add(10002); customerNames.add("Sara"); balances.add(5000.0); accountTypes.add("Current"); accountStatus.add("Active");
        accountNumbers.add(10003); customerNames.add("Ahmed"); balances.add(12000.0); accountTypes.add("Savings"); accountStatus.add("Active");
        accountNumbers.add(10004); customerNames.add("Omar"); balances.add(700.0); accountTypes.add("Current"); accountStatus.add("Suspended");
        accountNumbers.add(10005); customerNames.add("Fatima"); balances.add(950.0); accountTypes.add("Savings"); accountStatus.add("Active");
        accountNumbers.add(10006); customerNames.add("Salwa"); balances.add(1100.0); accountTypes.add("Savings"); accountStatus.add("Active");
        accountNumbers.add(10007); customerNames.add("Reem"); balances.add(400.0); accountTypes.add("Current"); accountStatus.add("Closed");
        accountNumbers.add(10008); customerNames.add("Tariq"); balances.add(500.0); accountTypes.add("Savings"); accountStatus.add("Active");
        accountNumbers.add(10009); customerNames.add("Hassan"); balances.add(650.0); accountTypes.add("Current"); accountStatus.add("Active");
        accountNumbers.add(10010); customerNames.add("Mona"); balances.add(1000.0); accountTypes.add("Savings"); accountStatus.add("Active");
        Scanner scanner = new Scanner(System.in);

        //2. Display Account Information
        System.out.println("Account Information:");
        for (int i = 0; i < accountNumbers.size(); i++) {
            System.out.println("Account Index: " + i);
            System.out.println("Account Number: " + accountNumbers.get(i));
            System.out.println("Customer: " + customerNames.get(i));
            System.out.println("Type: " + accountTypes.get(i));
            System.out.println("Balance: " + balances.get(i));
            System.out.println("Status: " + accountStatus.get(i));
            System.out.println("-------------------------");
        }

        //3. Create New Account
        System.out.println("Create New Account");
        System.out.print("Enter Customer Name: ");
        String newCustomer = scanner.nextLine();
        System.out.print("Enter Initial Balance: ");
        double newBalance = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Enter Account Type (Savings/Current): ");
        String newType = scanner.nextLine();

        if (newBalance < 0) {
            System.out.println("Error: Balance cannot be negative.");
        } else if (!(newType.equals("Savings") || newType.equals("Current"))) {
            System.out.println("Error: Invalid account type.");
        } else {
            int newAccountNumber = accountNumbers.get(accountNumbers.size() - 1) + 1;
            accountNumbers.add(newAccountNumber);
            customerNames.add(newCustomer);
            balances.add(newBalance);
            accountTypes.add(newType);
            accountStatus.add("Active");
            System.out.println("Account created successfully. Account Number: " + newAccountNumber);
        }

        //4. Deposit Money System
        System.out.print("Enter Account Number for Deposit: ");
        int depositAcc = scanner.nextInt();
        if (accountNumbers.contains(depositAcc)) {
            int index = accountNumbers.indexOf(depositAcc);
            System.out.print("Enter Deposit Amount: ");
            double depositAmount = scanner.nextDouble();
            if (depositAmount > 0) {
                balances.set(index, balances.get(index) + depositAmount);
                System.out.println("Deposit completed. New Balance: " + balances.get(index));
            } else {
                System.out.println("Error: Deposit must be greater than zero.");
            }
        } else {
            System.out.println("Account not found.");
        }

        //5. Withdraw Money System
        System.out.print("Enter Account Number for Withdrawal: ");
        int withdrawAcc = scanner.nextInt();
        if (accountNumbers.contains(withdrawAcc)) {
            int index = accountNumbers.indexOf(withdrawAcc);
            System.out.print("Enter Withdrawal Amount: ");
            double withdrawAmount = scanner.nextDouble();
            if (withdrawAmount > 0 && withdrawAmount <= balances.get(index)) {
                balances.set(index, balances.get(index) - withdrawAmount);
                System.out.println("Withdrawal successful. Remaining Balance: " + balances.get(index));
            } else {
                System.out.println("Error: Invalid withdrawal amount.");
            }
        } else {
            System.out.println("Account not found.");
        }

        //6. Transfer Money System
        System.out.print("Enter Sender Account Number: ");
        int senderAcc = scanner.nextInt();
        System.out.print("Enter Receiver Account Number: ");
        int receiverAcc = scanner.nextInt();
        System.out.print("Enter Transfer Amount: ");
        double transferAmount = scanner.nextDouble();
        if (accountNumbers.contains(senderAcc) && accountNumbers.contains(receiverAcc)) {
            int senderIndex = accountNumbers.indexOf(senderAcc);
            int receiverIndex = accountNumbers.indexOf(receiverAcc);
            if (transferAmount > 0 && balances.get(senderIndex) >= transferAmount) {
                balances.set(senderIndex, balances.get(senderIndex) - transferAmount);
                balances.set(receiverIndex, balances.get(receiverIndex) + transferAmount);
                System.out.println("Transfer successful.");
            } else {
                System.out.println("Error: Invalid transfer amount.");
            }
        } else {
            System.out.println("Error: Account not found.");
        }

        //7. Account Search System
        System.out.println("Search Account System");
        System.out.println("Option 1: Search by Account Number");
        System.out.println("Option 2: Search by Customer Name");
        int option = scanner.nextInt();
        scanner.nextLine();
        if (option == 1) {
            System.out.print("Enter Account Number: ");
            int searchAcc = scanner.nextInt();
            if (accountNumbers.contains(searchAcc)) {
                int index = accountNumbers.indexOf(searchAcc);
                System.out.println("Account found: " + customerNames.get(index) + " - Balance: " + balances.get(index) + " - Status: " + accountStatus.get(index));
            } else {
                System.out.println("Account not found.");
            }
        } else if (option == 2) {
            System.out.print("Enter Customer Name: ");
            String searchName = scanner.nextLine();
            if (customerNames.contains(searchName)) {
                int index = customerNames.indexOf(searchName);
                System.out.println("Account found: " + accountNumbers.get(index) + " - Balance: " + balances.get(index) + " - Status: " + accountStatus.get(index));
            } else {
                System.out.println("Account not found.");
            }
        }

        //8. Banking Statistics Report
        int totalAccounts = accountNumbers.size();
        double totalBalance = 0;
        double highest = balances.get(0);
        double lowest = balances.get(0);
        for (double bal : balances) {
            totalBalance += bal;
            if (bal > highest) highest = bal;
            if (bal < lowest) lowest = bal;
        }
        double averageBalance = (double) totalBalance / totalAccounts;
        System.out.println("Total Accounts: " + totalAccounts);
        System.out.println("Total Balance: " + totalBalance);
        System.out.println("Average Balance: " + averageBalance);
        System.out.println("Highest Balance: " + highest);
        System.out.println("Lowest Balance: " + lowest);

        //9. Account Status Analysis
        int active = 0, suspended = 0, closed = 0;
        for (String status : accountStatus) {
            if (status.equals("Active")) active++;
            else if (status.equals("Suspended")) suspended++;
            else if (status.equals("Closed")) closed++;
        }
        System.out.println("Active Accounts: " + active);
        System.out.println("Suspended Accounts: " + suspended);
        System.out.println("Closed Accounts: " + closed);

        //10. Update Account Information
        System.out.print("Enter Account Index to update: ");
        int updateIndex = scanner.nextInt();
        scanner.nextLine();

        if (updateIndex >= 0 && updateIndex < accountNumbers.size()) {
            System.out.print("Enter Updated Customer Name: ");
            String updateName = scanner.nextLine();

            System.out.print("Enter Updated Account Type (Savings/Current): ");
            String updateType = scanner.nextLine();

            System.out.print("Enter Updated Status (Active/Suspended/Closed): ");
            String updateStatus = scanner.nextLine();

            // apply updates
            customerNames.set(updateIndex, updateName);
            accountTypes.set(updateIndex, updateType);
            accountStatus.set(updateIndex, updateStatus);

            System.out.println("Account updated successfully.");
            System.out.println("Updated Account: "
                    + accountNumbers.get(updateIndex) + " - "
                    + customerNames.get(updateIndex) + " - "
                    + accountTypes.get(updateIndex) + " - "
                    + accountStatus.get(updateIndex));
        } else {
            System.out.println("Invalid index.");

            //11. Remove Account
            System.out.print("Enter Account Index to remove: ");
            int removeIndex = scanner.nextInt();

            if (removeIndex >= 0 && removeIndex < accountNumbers.size()) {
                accountNumbers.remove(removeIndex);
                customerNames.remove(removeIndex);
                balances.remove(removeIndex);
                accountTypes.remove(removeIndex);
                accountStatus.remove(removeIndex);

                System.out.println("Account removed successfully.");
                System.out.println("Updated Account List:");
                for (int i = 0; i < accountNumbers.size(); i++) {
                    System.out.println("Account Index: " + i);
                    System.out.println("Account Number: " + accountNumbers.get(i));
                    System.out.println("Customer: " + customerNames.get(i));
                    System.out.println("Type: " + accountTypes.get(i));
                    System.out.println("Balance: " + balances.get(i));
                    System.out.println("Status: " + accountStatus.get(i));
                    System.out.println("-------------------------");
                }
            } else {
                System.out.println("Invalid index.");
            }

        }

        //12. Sorting Accounts

        // Sort by Balance (Lowest to Highest)
        ArrayList<Double> sortedAsc = new ArrayList<>(balances);
        Collections.sort(sortedAsc);
        System.out.println("Accounts Sorted by Balance (Ascending):");
        for (double bal : sortedAsc) {
            int index = balances.indexOf(bal);
            System.out.println(customerNames.get(index) + " - Balance: " + bal);
        }

        // Sort by Balance (Highest to Lowest)
        ArrayList<Double> sortedDesc = new ArrayList<>(balances);
        Collections.sort(sortedDesc, Collections.reverseOrder());
        System.out.println("Accounts Sorted by Balance (Descending):");
        for (double bal : sortedDesc) {
            int index = balances.indexOf(bal);
            System.out.println(customerNames.get(index) + " - Balance: " + bal);
        }

        // Sort by Customer Name Alphabetically
        ArrayList<String> sortedNames = new ArrayList<>(customerNames);
        Collections.sort(sortedNames);
        System.out.println("Accounts Sorted by Customer Name:");
        for (String name : sortedNames) {
            int index = customerNames.indexOf(name);
            System.out.println(name + " - Account Number: " + accountNumbers.get(index) + " - Balance: " + balances.get(index));
        }

    }
}
