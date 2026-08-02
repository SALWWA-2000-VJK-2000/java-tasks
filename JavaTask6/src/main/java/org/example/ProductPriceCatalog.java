package org.example;
import java.util.HashMap;
import java.util.Scanner;
public class ProductPriceCatalog {
        public static void main(String[] args) {
            // 3: Declare variables
            Scanner scanner = new Scanner(System.in);
            HashMap<String, Double> productCatalog = new HashMap<>();

            // 5: Prompt user for number of products
            System.out.print("Enter the number of products: ");
            int numberOfProducts = scanner.nextInt();
            scanner.nextLine();

            // 6: Validate input
            if (numberOfProducts <= 0) {
                System.out.println("Invalid number of products.");
            } else {
                // 7: Read product name and price in a loop
                for (int i = 1; i <= numberOfProducts; i++) {
                    System.out.print("Enter Product Name " + i + ": ");
                    String productName = scanner.nextLine();

                    if (productCatalog.containsKey(productName)) {
                        System.out.println("Product already exists. Record not added.");
                        i--; // repeat this iteration
                    } else {
                        System.out.print("Enter Price: ");
                        double price = scanner.nextDouble();
                        scanner.nextLine(); // consume newline
                        productCatalog.put(productName, price);
                    }
                }

                // 8: Prompt for product name to search
                System.out.print("Enter a product name to search for: ");
                String searchProduct = scanner.nextLine();

                String searchResult;
                // 9 & 10: Search and update
                if (productCatalog.containsKey(searchProduct)) {
                    double currentPrice = productCatalog.get(searchProduct);
                    System.out.println("Product Found. Current Price: " + currentPrice);

                    System.out.print("Do you want to update the price? (Y/N): ");
                    String choice = scanner.nextLine();

                    if (choice.equals("Y")) {
                        System.out.print("Enter new price: ");
                        double newPrice = scanner.nextDouble();
                        scanner.nextLine(); // consume newline
                        productCatalog.replace(searchProduct, newPrice);
                        searchResult = "Price updated successfully.";
                    } else {
                        searchResult = "No update performed.";
                    }
                } else {
                    searchResult = "Product not found.";
                }

                // 11: Classify inventory
                int uniqueCount = productCatalog.size();
                String classification;
                if (uniqueCount < 5) {
                    classification = "Small Inventory";
                } else if (uniqueCount <= 10) {
                    classification = "Medium Inventory";
                } else {
                    classification = "Large Inventory";
                }

                // 12: Display results
                System.out.println("\n--- Product Catalog Summary ---");
                System.out.println("Total products entered: " + numberOfProducts);
                System.out.println("Total unique products: " + uniqueCount);
                System.out.println("All product names and prices:");
                for (String name : productCatalog.keySet()) {
                    System.out.println("Product: " + name + ", Price: " + productCatalog.get(name));
                }
                System.out.println("Search and update result: " + searchResult);
                System.out.println("Inventory classification: " + classification);
            }

            // 14: Close scanner
            scanner.close();
        }
    }
