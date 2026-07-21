package org.example;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ArrayListProductInventory {
    static void main() {
        ArrayList<String> productNames = new ArrayList<>();
        ArrayList<Integer> productQuantities = new ArrayList<>();
        ArrayList<Double> productPrices= new ArrayList<>();

        // add products
        productNames.add("Laptop"); productQuantities.add(5); productPrices.add(750.50);
        productNames.add("Mouse"); productQuantities.add(20); productPrices.add(15.5);
        productNames.add("Keyboard"); productQuantities.add(10); productPrices.add(25.0);
        productNames.add("Monitor"); productQuantities.add(7); productPrices.add(150.0);
        productNames.add("Printer"); productQuantities.add(0); productPrices.add(120.0);
        productNames.add("Tablet"); productQuantities.add(12); productPrices.add(300.0);
        productNames.add("Phone"); productQuantities.add(8); productPrices.add(500.0);
        productNames.add("Camera"); productQuantities.add(3); productPrices.add(450.0);
        productNames.add("Headphones"); productQuantities.add(15); productPrices.add(60.0);
        productNames.add("Charger"); productQuantities.add(25); productPrices.add(20.0);

        Scanner scanner = new Scanner(System.in);

        //Display Inventory
        System.out.println("Inventory:");
        for (int i = 0; i < productNames.size(); i++) {
            System.out.println("Product " + i + ": ");
            System.out.println("Name: " + productNames.get(i));
            System.out.println("Quantity: " + productQuantities.get(i));
            System.out.println("Price: " + productPrices.get(i));
        }

        //Add New Product
        System.out.print("Enter Product Name: ");
        String newName = scanner.nextLine();
        System.out.print("Enter Quantity: ");
        int newQuantity = scanner.nextInt();
        System.out.print("Enter Price: ");
        double newPrice = scanner.nextDouble();
        productNames.add(newName);
        productQuantities.add(newQuantity);
        productPrices.add(newPrice);
        System.out.println("Product added successfully.");
        System.out.println(productNames);

        //Update Product Information
        System.out.print("Enter product index: ");
        int updateIndex = scanner.nextInt();
        scanner.nextLine();
        if (updateIndex >= 0 && updateIndex < productNames.size()) {
            System.out.print("New Product Name: ");
            String updatedName = scanner.nextLine();
            System.out.print("New Quantity: ");
            int updatedQuantity = scanner.nextInt();
            System.out.print("New Price: ");
            double updatedPrice = scanner.nextDouble();
            productNames.set(updateIndex, updatedName);
            productQuantities.set(updateIndex, updatedQuantity);
            productPrices.set(updateIndex, updatedPrice);
            System.out.println("Product updated successfully.");
        } else {
            System.out.println("Invalid index.");
        }

        //Search Product System
        System.out.print("Enter product name to search: ");
        String target = scanner.next();
        if (productNames.contains(target)) {
            int index = productNames.indexOf(target);
            System.out.println("Product found.");
            System.out.println("Index: " + index);
            System.out.println("Quantity: " + productQuantities.get(index));
            System.out.println("Price: " + productPrices.get(index));
        } else {
            System.out.println("Product not found.");
        }

        //Stock Analysis
        int totalProducts = productNames.size();
        int totalQuantity = 0;
        double inventoryValue = 0;
        for (int i = 0; i < productNames.size(); i++) {
            totalQuantity += productQuantities.get(i);
            inventoryValue += productQuantities.get(i) * productPrices.get(i);
        }
        System.out.println("Total Products: " + totalProducts);
        System.out.println("Total Quantity: " + totalQuantity);
        System.out.println("Inventory Value: " + inventoryValue);

        //Stock Status Checking
        System.out.println("Low Stock:");
        for (int i = 0; i < productNames.size(); i++) {
            if (productQuantities.get(i) < 5 && productQuantities.get(i) > 0) {
                System.out.println(productNames.get(i));
            }
        }
        System.out.println("Out of Stock:");
        for (int i = 0; i < productNames.size(); i++) {
            if (productQuantities.get(i) == 0) {
                System.out.println(productNames.get(i));
            }
        }
        System.out.println("Available Stock:");
        for (int i = 0; i < productNames.size(); i++) {
            if (productQuantities.get(i) >= 5) {
                System.out.println(productNames.get(i));
            }
        }

        //Remove Product
        System.out.print("Remove Product Index: ");
        int removeIndex = scanner.nextInt();
        if (removeIndex >= 0 && removeIndex < productNames.size()) {
            productNames.remove(removeIndex);
            productQuantities.remove(removeIndex);
            productPrices.remove(removeIndex);
            System.out.println("Product removed successfully.");
        } else {
            System.out.println("Invalid index.");
        }

        //Sorting Products
        //Sort by name
        ArrayList<String> sortedNames = new ArrayList<>(productNames);
        Collections.sort(sortedNames);
        System.out.println("Sorted by Name: " + sortedNames);

        //Sort by price
        ArrayList<Double> sortedPrices = new ArrayList<>(productPrices);
        Collections.sort(sortedPrices);
        System.out.println("Sorted by Price: " + sortedPrices);

        scanner.close();
    }
}


