package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class LibraryBookManagementSystem {
     void main(){
        ArrayList<String> bookTitles = new ArrayList<>();
        ArrayList<String> authors = new ArrayList<>();
        ArrayList<Boolean> availability = new ArrayList<>();

        // add Book
        bookTitles.add("Title1"); authors.add("Ali"); availability.add(true);
        bookTitles.add("Title2"); authors.add("Sara"); availability.add(false);
        bookTitles.add("Title3"); authors.add("Ahmed"); availability.add(true);
        bookTitles.add("Title4"); authors.add("Omar"); availability.add(false);
        bookTitles.add("Title5"); authors.add("Fatima"); availability.add(true);
        bookTitles.add("Title6"); authors.add("Salwa"); availability.add(true);
        bookTitles.add("Title7"); authors.add("Reem"); availability.add(true);
        bookTitles.add("Title7"); authors.add("Tariq"); availability.add(false);
        bookTitles.add("Title8"); authors.add("Hassan"); availability.add(true);
        bookTitles.add("Title9"); authors.add("Mona"); availability.add(true);

        //Display Library Books
        Scanner scanner = new Scanner(System.in);

        System.out.println("Book Information:");
        for (int i = 0; i < bookTitles.size(); i++) {
            System.out.println("Book: " + i + ": ");
            System.out.println(" Title: " + bookTitles.get(i));
            System.out.println("Author: " + authors.get(i));
            System.out.println("available : " + availability.get(i));
        }

        //Add New Book
        System.out.println(" Add New Book");
        System.out.print("Enter Book Title: ");
        String newBook = scanner.nextLine();
        System.out.print("Enter Author: ");
        String newAuthor = scanner.nextLine();
        System.out.print("Enter Available: ");
        Boolean available = scanner.nextBoolean();
        bookTitles.add(newBook);
        authors.add(newAuthor);
        availability.add(available);
        System.out.println("Book added successfully.");
        System.out.println(bookTitles);


        //4. Update Book Information
        System.out.println("    Update Book Information   ");
        System.out.print("Enter Book Index: ");
        int updateIndex = scanner.nextInt();
        scanner.nextLine(); // consume newline

        if (updateIndex >= 0 && updateIndex < bookTitles.size()) {
            System.out.print("Enter New Title: ");
            String newTitle = scanner.nextLine();

            System.out.print("Enter New Author: ");
            String newAuthorname = scanner.nextLine();

            System.out.print("Available (true/false): ");
            boolean newAvailability = scanner.nextBoolean();

            // update values in the lists
            bookTitles.set(updateIndex, newTitle);
            authors.set(updateIndex, newAuthorname);
            availability.set(updateIndex, newAvailability);

            System.out.println("Book updated successfully.");
            System.out.println("Updated Book: " + bookTitles.get(updateIndex)
                    + " by " + authors.get(updateIndex)
                    + " - Available: " + availability.get(updateIndex));
        } else {
            System.out.println("Invalid index.");
        }

        //5. Search Book System
        System.out.print("Enter  a book title to search: ");
        String book = scanner.next();
        if (bookTitles.contains(book)) {
            int index = bookTitles.indexOf(book);
            System.out.println("Book found.");
            System.out.println("Position: " + index);
            System.out.println("Author name: " + authors.get(index));
            System.out.println("Is Availability?   " + availability.get(index));

        } else {
            System.out.println("Book not found.");
        }

        scanner.close();






    }
}
