package org.example;
import java.util.HashSet;
import java.util.HashMap;
import java.util.Scanner;

public class LibraryBookTracker {
    public static void main(String[] args) {
        // 3: Declare variables
        Scanner scanner = new Scanner(System.in);
        HashSet<Integer> bookIds = new HashSet<>();          // Set for unique IDs
        HashMap<Integer, String> bookCatalog = new HashMap<>(); // Map for ID → Title

        // 5: Prompt user for number of books
        System.out.print("Enter the number of books: ");
        int numberOfBooks = scanner.nextInt();
        scanner.nextLine();

        // 6: Validate input
        if (numberOfBooks <= 0) {
            System.out.println("Invalid number of books.");
        } else {
            // 7: Read book ID and title in a loop
            for (int i = 1; i <= numberOfBooks; i++) {
                System.out.print("Enter Book ID " + i + ": ");
                int bookId = scanner.nextInt();
                scanner.nextLine();

                if (bookIds.contains(bookId)) {
                    System.out.println("Duplicate Book ID. Record not added.");

                } else {
                    System.out.print("Enter Book Title: ");
                    String bookTitle = scanner.nextLine();
                    bookIds.add(bookId);
                    bookCatalog.put(bookId, bookTitle);
                }
            }

            // 8: Prompt for book ID to search
            System.out.print("Enter a Book ID to search: ");
            int searchId = scanner.nextInt();

            // 9 & 10: Search result
            if (bookCatalog.containsKey(searchId)) {
                System.out.println("Book Found:");
                System.out.println("ID: " + searchId);
                System.out.println("Title: " + bookCatalog.get(searchId));
            } else {
                System.out.println("Book not found.");
            }

            // 11: Classify library
            int uniqueCount = bookCatalog.size();
            String classification;
            if (uniqueCount < 5) {
                classification = "Small Library";
            } else if (uniqueCount <= 10) {
                classification = "Medium Library";
            } else {
                classification = "Large Library";
            }

            // 12: Display summary
            System.out.println("\n--- Library Summary ---");
            System.out.println("Total book records entered: " + numberOfBooks);
            System.out.println("Total unique books: " + uniqueCount);

            System.out.println("All Book IDs:");
            for (Integer id : bookIds) {
                System.out.println("ID: " + id);
            }

            System.out.println("All Book IDs with Titles:");
            for (Integer id : bookCatalog.keySet()) {
                System.out.println("ID: " + id + ", Title: " + bookCatalog.get(id));
            }

            System.out.println("Library classification: " + classification);
        }

        // 14: Close scanner
        scanner.close();
    }
}