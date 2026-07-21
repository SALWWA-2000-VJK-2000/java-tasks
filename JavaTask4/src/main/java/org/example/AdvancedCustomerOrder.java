package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class AdvancedCustomerOrder {
    void main(){
        // 1. Create Order Data Lists
        ArrayList<Integer> orderIds = new ArrayList<>();
        ArrayList<String> customerNames = new ArrayList<>();
        ArrayList<String> productNames = new ArrayList<>();
        ArrayList<Integer> quantities = new ArrayList<>();
        ArrayList<Double> prices = new ArrayList<>();
        ArrayList<String> orderStatus= new ArrayList<>();

        // add orders
        orderIds.add(1001); customerNames.add("Ali"); productNames.add("Laptop"); quantities.add(2); prices.add(750.0); orderStatus.add("Pending");
        orderIds.add(1002); customerNames.add("Sara"); productNames.add("Mouse"); quantities.add(5); prices.add(15.5); orderStatus.add("Shipped");
        orderIds.add(1003); customerNames.add("Ahmed"); productNames.add("Keyboard"); quantities.add(3); prices.add(25.0); orderStatus.add("Delivered");
        orderIds.add(1004); customerNames.add("Omar"); productNames.add("Monitor"); quantities.add(1); prices.add(150.0); orderStatus.add("Pending");
        orderIds.add(1005); customerNames.add("Fatima"); productNames.add("Printer"); quantities.add(2); prices.add(120.0); orderStatus.add("Cancelled");
        orderIds.add(1006); customerNames.add("Salwa"); productNames.add("Tablet"); quantities.add(4); prices.add(300.0); orderStatus.add("Shipped");
        orderIds.add(1007); customerNames.add("Reem"); productNames.add("Phone"); quantities.add(2); prices.add(500.0); orderStatus.add("Delivered");
        orderIds.add(1008); customerNames.add("Tariq"); productNames.add("Camera"); quantities.add(1); prices.add(450.0); orderStatus.add("Pending");
        orderIds.add(1009); customerNames.add("Hassan"); productNames.add("Headphones"); quantities.add(6); prices.add(60.0); orderStatus.add("Shipped");
        orderIds.add(1010); customerNames.add("Mona"); productNames.add("Charger"); quantities.add(10); prices.add(20.0); orderStatus.add("Delivered");
        orderIds.add(1011); customerNames.add("Jamal"); productNames.add("USB Cable"); quantities.add(15); prices.add(5.0); orderStatus.add("Pending");
        orderIds.add(1012); customerNames.add("Layla"); productNames.add("Power Bank"); quantities.add(3); prices.add(40.0); orderStatus.add("Shipped");
        orderIds.add(1013); customerNames.add("Nadia"); productNames.add("Smartwatch"); quantities.add(2); prices.add(200.0); orderStatus.add("Delivered");
        orderIds.add(1014); customerNames.add("Bilal"); productNames.add("Speaker"); quantities.add(4); prices.add(80.0); orderStatus.add("Pending");
        orderIds.add(1015); customerNames.add("Zain"); productNames.add("Router"); quantities.add(1); prices.add(100.0); orderStatus.add("Shipped");

        //2. Display Order Information
        System.out.println("Order Information:");
        for (int i = 0; i < orderIds.size(); i++) {
            double totalPrice = quantities.get(i) * prices.get(i); // Formula: Quantity × Price

            System.out.println("Order Index: " + i);
            System.out.println("Order ID: " + orderIds.get(i));
            System.out.println("Customer: " + customerNames.get(i));
            System.out.println("Product: " + productNames.get(i));
            System.out.println("Quantity: " + quantities.get(i));
            System.out.println("Price: " + prices.get(i));
            System.out.println("Total: " + totalPrice);
            System.out.println("Status: " + orderStatus.get(i));
            System.out.println("-------------------------");
        }

        //3. Add New Order
        Scanner scanner = new Scanner(System.in);
        System.out.println(" -----Add New Order------");
        System.out.print("Enter Customer name: ");
        String newName = scanner.nextLine();
        System.out.print("Enter Product name: ");
        String newProduct = scanner.nextLine();
        System.out.print("Enter Quantity: ");
        int newQuantity = scanner.nextInt();
        System.out.print("Enter Price: ");
        Double newPrice = scanner.nextDouble();
        System.out.print("Enter Order status:  ");
        String newStatus = scanner.nextLine();
        customerNames.add(newName);
        productNames.add(newProduct);
        prices.add(newPrice);
        orderStatus.add(newStatus);
        System.out.println("Order added successfully.");
        System.out.println("Updated order count: "+ customerNames.size());


        // 4. Calculate Order Statistics
        int totalOrder = orderIds.size();
        double totalSales = 0;
        double highest = quantities.get(0) * prices.get(0);
        double lowest = quantities.get(0) * prices.get(0);

        for (int i = 0; i < orderIds.size(); i++) {
            double orderValue = quantities.get(i) * prices.get(i);
            totalSales += orderValue;

            if (orderValue > highest) {
                highest = orderValue;
            }
            if (orderValue < lowest) {
                lowest = orderValue;
            }
        }
        double average = (double) totalSales / totalOrder;
        System.out.println("Total Orders: " + totalOrder);   // Total number of orders
        System.out.println("Total Sales: " + totalSales);    // Total sales amount
        System.out.println("Average Order: " + average);     // Average order value
        System.out.println("Highest Order: " + highest);     // Highest order value
        System.out.println("Lowest Order: " + lowest);       // Lowest order value


        //5. Order Status Analysis
        int pending = 0;
        int completed = 0;
        int cancelled = 0;

        for (String status : orderStatus) {
            if (status.equals("Pending")) {
                pending++;
            } else if (status.equals("Completed")) {
                completed++;
            } else if (status.equals("Cancelled")) {
                cancelled++;
            }
        }
        System.out.println("Pending Orders: " + pending);
        System.out.println("Completed Orders: " + completed);
        System.out.println("Cancelled Orders: " + cancelled);

//6. Search Order System
        System.out.println("Search Order System");
        System.out.println("Option 1: Search by Order ID");
        System.out.println("Option 2: Search by Customer Name");
        int option = scanner.nextInt();
        scanner.nextLine();

        boolean found = false;
        if (option == 1) {
            System.out.print("Enter Order ID: ");
            int searchId = scanner.nextInt();
            if (orderIds.contains(searchId)) {
                int index = orderIds.indexOf(searchId);
                double totalPrice = quantities.get(index) * prices.get(index);
                System.out.println("Order found.");
                System.out.println("Customer: " + customerNames.get(index));
                System.out.println("Product: " + productNames.get(index));
                System.out.println("Quantity: " + quantities.get(index));
                System.out.println("Price: " + prices.get(index));
                System.out.println("Total: " + totalPrice);
                System.out.println("Status: " + orderStatus.get(index));
                found = true;
            }
        } else if (option == 2) {
            System.out.print("Enter Customer Name: ");
            String searchName = scanner.nextLine();
            if (customerNames.contains(searchName)) {
                int index = customerNames.indexOf(searchName);
                double totalPrice = quantities.get(index) * prices.get(index);
                System.out.println("Order found.");
                System.out.println("Order ID: " + orderIds.get(index));
                System.out.println("Product: " + productNames.get(index));
                System.out.println("Quantity: " + quantities.get(index));
                System.out.println("Price: " + prices.get(index));
                System.out.println("Total: " + totalPrice);
                System.out.println("Status: " + orderStatus.get(index));
                found = true;
            }
        }
        if (!found) {
            System.out.println("Order not found.");
        }

        //7. Update Order System
        System.out.print("Enter Order Index to update: ");
        int updateIndex = scanner.nextInt();
        scanner.nextLine();
        if (updateIndex >= 0 && updateIndex < orderIds.size()) {
            System.out.print("Enter New Customer Name: ");
            String updateCustomer = scanner.nextLine();
            System.out.print("Enter New Product Name: ");
            String updateProduct = scanner.nextLine();
            System.out.print("Enter New Quantity: ");
            int updateQuantity = scanner.nextInt();
            System.out.print("Enter New Price: ");
            double updatePrice = scanner.nextDouble();
            scanner.nextLine();
            System.out.print("Enter New Status (Pending/Completed/Cancelled): ");
            String updateStatus = scanner.nextLine();

            // Validation
            if (updateQuantity <= 0) {
                System.out.println("Error: Quantity must be greater than 0.");
            } else if (updatePrice < 0) {
                System.out.println("Error: Price cannot be negative.");
            } else if (!(updateStatus.equals("Pending") ||
                    updateStatus.equals("Completed") ||
                    updateStatus.equals("Cancelled"))) {
                System.out.println("Error: Invalid status.");
            } else {
                customerNames.set(updateIndex, updateCustomer);
                productNames.set(updateIndex, updateProduct);
                quantities.set(updateIndex, updateQuantity);
                prices.set(updateIndex, updatePrice);
                orderStatus.set(updateIndex,updateStatus);

                System.out.println("Order updated successfully.");
                double totalPrice = updateQuantity * updatePrice;
                System.out.println("Updated Order: " + orderIds.get(updateIndex) + " - "
                        + customerNames.get(updateIndex) + " - " + productNames.get(updateIndex)
                        + " - Total: " + totalPrice + " - Status: " + orderStatus.get(updateIndex));
            }
        } else {
            System.out.println("Invalid index.");
        }

//8. Discount Calculation System
        System.out.print("Enter Order Index for Discount Calculation: ");
        int discountIndex = scanner.nextInt();
        if (discountIndex >= 0 && discountIndex < orderIds.size()) {
            double total = quantities.get(discountIndex) * prices.get(discountIndex);
            double discount = 0;
            if (total >= 5000) {
                discount = total * 0.15;
            } else if (total >= 2000) {
                discount = total * 0.10;
            } else if (total >= 1000) {
                discount = total * 0.05;
            }
            double finalPrice = total - discount;
            System.out.println("Original Price: " + total);
            System.out.println("Discount Amount: " + discount);
            System.out.println("Final Price: " + finalPrice);
        } else {
            System.out.println("Invalid index.");
        }

//9. Remove Order
        System.out.print("Enter Order Index to remove: ");
        int removeIndex = scanner.nextInt();
        if (removeIndex >= 0 && removeIndex < orderIds.size()) {
            orderIds.remove(removeIndex);
            customerNames.remove(removeIndex);
            productNames.remove(removeIndex);
            quantities.remove(removeIndex);
            prices.remove(removeIndex);
            orderStatus.remove(removeIndex);
            System.out.println("Order removed successfully.");
        } else {
            System.out.println("Invalid index.");
        }

        //10. Sorting Orders
        // Sort by Total Price Ascending
        ArrayList<Double> totalValues = new ArrayList<>();
        for (int i = 0; i < orderIds.size(); i++) {
            totalValues.add(quantities.get(i) * prices.get(i));
        }
        ArrayList<Double> sortedAsc = new ArrayList<>(totalValues);
        Collections.sort(sortedAsc);
        System.out.println("Orders Sorted by Total Price (Ascending): " + sortedAsc);

        // Sort by Total Price Descending
        ArrayList<Double> sortedDesc = new ArrayList<>(totalValues);
        Collections.sort(sortedDesc, Collections.reverseOrder());
        System.out.println("Orders Sorted by Total Price (Descending): " + sortedDesc);

        // Sort by Customer Name Alphabetically
        ArrayList<String> sortedNames = new ArrayList<>(customerNames);
        Collections.sort(sortedNames);
        System.out.println("Orders Sorted by Customer Name: " + sortedNames);


        scanner.close();
    }
}
