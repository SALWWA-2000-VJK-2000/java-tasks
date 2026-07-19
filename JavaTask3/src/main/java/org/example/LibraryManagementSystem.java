package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LibraryManagementSystem {
    public static void main(String[] args) {
        // Create lists to store book information
        List<String> bookNames = new ArrayList<>();
        List<String> authorNames = new ArrayList<>();
        List<Boolean> availabilityStatus = new ArrayList<>();

        // Add at least 10 books with authors and availability
        bookNames.add("Java Programming"); authorNames.add("Author1"); availabilityStatus.add(true);
        bookNames.add("Effective Java"); authorNames.add("Author2"); availabilityStatus.add(true);
        bookNames.add("Clean Code"); authorNames.add("Author3"); availabilityStatus.add(false);
        bookNames.add("Design Patterns"); authorNames.add("Author4"); availabilityStatus.add(true);
        bookNames.add("Algorithms"); authorNames.add("Author5"); availabilityStatus.add(true);
        bookNames.add("Database Systems"); authorNames.add("Author6"); availabilityStatus.add(false);
        bookNames.add("Operating Systems"); authorNames.add("Author7"); availabilityStatus.add(true);
        bookNames.add("Computer Networks"); authorNames.add("Author8"); availabilityStatus.add(true);
        bookNames.add("Artificial Intelligence"); authorNames.add("Author9"); availabilityStatus.add(true);
        bookNames.add("Software Engineering"); authorNames.add("Author10"); availabilityStatus.add(false);

        Scanner scanner = new Scanner(System.in);
        int choice;

        // Loop to keep displaying the menu until Exit
        do {
            System.out.println("Library Management System Menu: ");
            System.out.println("1: Display all books");
            System.out.println("2: Search for a book");
            System.out.println("3: Borrow a book");
            System.out.println("4: Return a book");
            System.out.println("5: Display library report");
            System.out.println("6: Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    displayBooks(bookNames, authorNames, availabilityStatus);
                    break;
                case 2:
                    System.out.print("Enter book name to search: ");
                    String searchName = scanner.nextLine();
                    searchBook(bookNames, searchName);
                    break;
                case 3:
                    System.out.print("Enter book name to borrow: ");
                    String borrowName = scanner.nextLine();
                    borrowBook(bookNames, availabilityStatus, borrowName);
                    break;
                case 4:
                    System.out.print("Enter book name to return: ");
                    String returnName = scanner.nextLine();
                    returnBook(bookNames, availabilityStatus, returnName);
                    break;
                case 5:
                    displayReport(bookNames, availabilityStatus);
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

    // Method to display all books
    public static void displayBooks(List<String> bookNames, List<String> authorNames, List<Boolean> availabilityStatus) {
        System.out.println("Book List ");
        for (int i = 0; i < bookNames.size(); i++) {
            String status = availabilityStatus.get(i) ? "Available" : "Unavailable";
            System.out.println("Book: " + bookNames.get(i) +
                    "  Author: " + authorNames.get(i) +
                    "  Status: " + status);
        }
    }

    // Method to search for a book
    public static void searchBook(List<String> bookNames, String searchName) {
        if (bookNames.contains(searchName)) {
            System.out.println(searchName + " exists in the library.");
        } else {
            System.out.println(searchName + " does not exist in the library.");
        }
    }

    // Method to borrow a book
    public static void borrowBook(List<String> bookNames, List<Boolean> availabilityStatus, String borrowName) {
        int index = bookNames.indexOf(borrowName);
        if (index != -1) {
            if (availabilityStatus.get(index)) {
                availabilityStatus.set(index, false);
                System.out.println("You have borrowed: " + borrowName);
            } else {
                System.out.println("Sorry, " + borrowName + " is currently unavailable.");
            }
        } else {
            System.out.println("Book not found.");
        }
    }

    // Method to return a book
    public static void returnBook(List<String> bookNames, List<Boolean> availabilityStatus, String returnName) {
        int index = bookNames.indexOf(returnName);
        if (index != -1) {
            availabilityStatus.set(index, true);
            System.out.println("You have returned: " + returnName);
        } else {
            System.out.println("Book not found.");
        }
    }

    // Method to count available and unavailable books
    public static int[] countBooks(List<Boolean> availabilityStatus) {
        int availableCount = 0;
        int unavailableCount = 0;
        for (Boolean status : availabilityStatus) {
            if (status) {
                availableCount++;
            } else {
                unavailableCount++;
            }
        }
        return new int[]{availableCount, unavailableCount};
    }

    // Method to display library report
    public static void displayReport(List<String> bookNames, List<Boolean> availabilityStatus) {
        int[] counts = countBooks(availabilityStatus);
        System.out.println("Library Report ");
        System.out.println("Total Books: " + bookNames.size());
        System.out.println("Available Books: " + counts[0]);
        System.out.println("Unavailable Books: " + counts[1]);
    }
}
