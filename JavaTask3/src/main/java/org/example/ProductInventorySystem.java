package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductInventorySystem {
    public static void main(String[] args) {
        // Create lists to store product information
        List<String> productNames = new ArrayList<>();
        List<Double> productPrices = new ArrayList<>();
        List<Integer> productQuantities = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);

        // Loop to allow user to enter information for 10 products
        for (int i = 1; i <= 10; i++) {
            System.out.println("Enter details for Product " + i);

            System.out.print("Product Name: ");
            String name = scanner.nextLine();

            System.out.print("Product Price: ");
            double price = scanner.nextDouble();

            System.out.print("Product Quantity: ");
            int quantity = scanner.nextInt();
            scanner.nextLine(); // consume newline

            // Store product information in lists
            productNames.add(name);
            productPrices.add(price);
            productQuantities.add(quantity);
        }

        // Calculate total inventory value
        double totalValue = calculateTotalValue(productPrices, productQuantities);

        // Count stock status
        int[] stockCounts = countStockStatus(productQuantities);

        // Find most expensive product
        String mostExpensiveProduct = findMostExpensiveProduct(productNames, productPrices);

        // Display complete inventory report
        displayReport(productNames, productPrices, productQuantities, totalValue, stockCounts, mostExpensiveProduct);

        scanner.close();
    }

    // Method to calculate total inventory value
    public static double calculateTotalValue(List<Double> prices, List<Integer> quantities) {
        double total = 0;
        for (int i = 0; i < prices.size(); i++) {
            total += prices.get(i) * quantities.get(i);
        }
        return total;
    }

    // Method to check stock status
    public static String checkStockStatus(int quantity) {
        if (quantity > 10) {
            return "High Stock";
        } else if (quantity > 0) {
            return "Available";
        } else {
            return "Out of Stock";
        }
    }

    // Method to count stock status
    public static int[] countStockStatus(List<Integer> quantities) {
        int availableCount = 0;
        int outOfStockCount = 0;
        for (int quantity : quantities) {
            if (quantity > 0) {
                availableCount++;
            } else {
                outOfStockCount++;
            }
        }
        return new int[]{availableCount, outOfStockCount};
    }

    // Method to find most expensive product
    public static String findMostExpensiveProduct(List<String> names, List<Double> prices) {
        double maxPrice = prices.get(0);
        String productName = names.get(0);
        for (int i = 1; i < prices.size(); i++) {
            if (prices.get(i) > maxPrice) {
                maxPrice = prices.get(i);
                productName = names.get(i);
            }
        }
        return productName;
    }

    // Method to display inventory report
    public static void displayReport(List<String> names, List<Double> prices, List<Integer> quantities,
                                     double totalValue, int[] stockCounts, String mostExpensiveProduct) {
        System.out.println("Inventory Report ");

        // Display each product with details
        for (int i = 0; i < names.size(); i++) {
            String status = checkStockStatus(quantities.get(i));
            System.out.println("Product: " + names.get(i));
            System.out.println("   Price: " + prices.get(i));
            System.out.println("   Quantity: " + quantities.get(i));
            System.out.println("   Stock Status: " + status);
            System.out.println();
        }

        // Display summary
        System.out.println("Total Inventory Value: " + totalValue);
        System.out.println("Available Products: " + stockCounts[0]);
        System.out.println("Out of Stock Products: " + stockCounts[1]);
        System.out.println("Most Expensive Product: " + mostExpensiveProduct);

    }
}
