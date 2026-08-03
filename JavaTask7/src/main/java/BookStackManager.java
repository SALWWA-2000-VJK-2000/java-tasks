import java.util.Scanner;
import java.util.Stack;

public class BookStackManager {
    static void main() {
        Stack<String> bookStack = new Stack<>();
        Scanner scanner = new Scanner(System.in);
        // Prompt user for password
        System.out.print("Enter the book number: ");
        int bookNumber = scanner.nextInt();
        scanner.nextLine();
        // Validate input
        if (bookNumber <= 0) {
            System.out.println("Invalid number of books.");
        }else {
            //  7: Read names in a loop
            for (int i = 1; i <= bookNumber; i++) {
                System.out.print("Enter Book Title " + i + ": ");
                String bookTitle = scanner.nextLine();
                bookStack.push(bookTitle);
            }
        }


        // 8: Menu loop
        int choice;
        do {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Add Book");
            System.out.println("2. Remove Top Book");
            System.out.println("3. View Top Book");
            System.out.println("4. Search Book");
            System.out.println("5. Display All Books");
            System.out.println("6. Display Stack Statistics");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1: // Add Book
                    System.out.print("Enter new Book Title: ");
                    String newBook = scanner.nextLine();
                    bookStack.push(newBook);
                    System.out.println("Book added successfully.");
                    break;

                case 2: // Remove Top Book
                    if (bookStack.isEmpty()) {
                        System.out.println("No books available.");
                    } else {
                        String removedBook = bookStack.pop();
                        System.out.println("Removed Book: " + removedBook);
                    }
                    break;

                case 3: // View Top Book
                    if (bookStack.isEmpty()) {
                        System.out.println("No books available.");
                    } else {
                        System.out.println("Top Book: " + bookStack.peek());
                    }
                    break;

                case 4: // Search Book
                    System.out.print("Enter Book Title to search: ");
                    String searchBook = scanner.nextLine();
                    int position = bookStack.search(searchBook);
                    if (position == -1) {
                        System.out.println("Book not found.");
                    } else {
                        System.out.println("Book found at position " + position + " from the top.");
                    }
                    break;

                case 5: // Display All Books
                    if (bookStack.isEmpty()) {
                        System.out.println("No books available.");
                    } else {
                        System.out.println("\n--- All Books in Stack ---");
                        for (String book : bookStack) {
                            System.out.println(book);
                        }
                    }
                    break;

                case 6: // Display Stack Statistics
                    System.out.println("\n--- Stack Statistics ---");
                    System.out.println("Total number of books: " + bookStack.size());
                    if (!bookStack.isEmpty()) {
                        System.out.println("Top book: " + bookStack.peek());
                    } else {
                        System.out.println("Top book: None");
                    }
                    System.out.println("Is stack empty? " + bookStack.isEmpty());
                    break;

                case 7: // Exit
                    System.out.println("Exiting system...");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 7);

        // 14: Close scanner
        scanner.close();
    }
}
