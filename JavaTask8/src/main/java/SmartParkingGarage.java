import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class SmartParkingGarage {
    public static void main(String[] args) {
        Queue<String> waiting_vehicles = new LinkedList<>();
        Stack<String> parked_vehicles = new Stack<>();
        int parking_capacity = 10;
        int parked_counter = 0;
        int departed_counter = 0;

        Scanner scanner = new Scanner(System.in);

        int option;
        do {
            System.out.print("\n===== Parking System =====\n");
            System.out.print("1. Add Vehicle to Waiting Queue\n");
            System.out.print("2. Park Next Vehicle\n");
            System.out.print("3. Remove Parked Vehicle\n");
            System.out.print("4. View Next Waiting Vehicle\n");
            System.out.print("5. View Last Parked Vehicle\n");
            System.out.print("6. Display Waiting Queue\n");
            System.out.print("7. Display Parked Vehicles\n");
            System.out.print("8. Search Vehicle\n");
            System.out.print("9. Display Garage Statistics\n");
            System.out.print("10. Clear Waiting Queue\n");
            System.out.print("11. Clear Parking Garage\n");
            System.out.print("12. Exit\n");

            System.out.print("Enter number of option: ");
            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    System.out.print("Add Vehicle\n");
                    System.out.print("Enter vehicle number: ");
                    String input2 = scanner.nextLine();
                    if (waiting_vehicles.contains(input2) || parked_vehicles.contains(input2)) {
                        System.out.print("Vehicle already exists.\n");
                    } else {
                        waiting_vehicles.offer(input2);
                        System.out.print("Vehicle added successfully.\n");
                    }
                    break;

                case 2:
                    System.out.print("Park Next Vehicle\n");
                    if (parked_vehicles.size() >= parking_capacity) {
                        System.out.print("Garage is full.\n");
                    } else {
                        String vehicle = waiting_vehicles.poll();
                        if (vehicle != null) {
                            parked_vehicles.push(vehicle);
                            parked_counter++;
                            System.out.print("Parked vehicle: " + vehicle + "\n");
                            System.out.print("Counter is " + parked_counter + "\n");
                        } else {
                            System.out.print("No vehicles in waiting queue.\n");
                        }
                    }
                    break;

                case 3:
                    System.out.print("Remove Parked Vehicle\n");
                    if (!parked_vehicles.isEmpty()) {
                        System.out.print("Removed vehicle: " + parked_vehicles.pop() + "\n");
                        departed_counter++;
                        if (!waiting_vehicles.isEmpty()) {
                            String next_vehicle = waiting_vehicles.poll();
                            parked_vehicles.push(next_vehicle);
                            System.out.print("Automatically parked: " + next_vehicle + "\n");
                        }
                    } else {
                        System.out.print("No vehicles parked.\n");
                    }
                    break;

                case 4:
                    System.out.print("Next Waiting Vehicle\n");
                    System.out.print("The next vehicle waiting: " + waiting_vehicles.peek() + "\n");
                    break;

                case 5:
                    System.out.print("Last Parked Vehicle\n");
                    if (!parked_vehicles.isEmpty()) {
                        System.out.print(parked_vehicles.peek() + "\n");
                    } else {
                        System.out.print("No vehicles parked.\n");
                    }
                    break;

                case 6:
                    System.out.print("Total waiting vehicles\n");
                    if (waiting_vehicles.isEmpty()) {
                        System.out.print("No vehicles are waiting.\n");
                    } else {
                        System.out.print("Waiting vehicle numbers: " + waiting_vehicles + "\n");
                        System.out.print("Total waiting vehicles: " + waiting_vehicles.size() + "\n");
                    }
                    break;

                case 7:
                    System.out.print("Display Parked Vehicles\n");
                    System.out.print("Vehicles from newest parked to oldest: " + parked_vehicles + "\n");
                    System.out.print("Current occupied spaces: " + parked_vehicles.size() + "\n");
                    int remainingSpaces = parking_capacity - parked_vehicles.size();
                    System.out.print("Remaining parking spaces: " + remainingSpaces + "\n");
                    break;

                case 8:
                    System.out.print("Enter vehicle number to search: ");
                    String input5 = scanner.nextLine();
                    if (parked_vehicles.contains(input5)) {
                        System.out.print(input5 + " is in parked vehicles\n");
                    } else if (waiting_vehicles.contains(input5)) {
                        System.out.print(input5 + " is in waiting vehicles\n");
                    } else {
                        System.out.print(input5 + " not found\n");
                    }
                    break;

                case 9:
                    System.out.print("\n===== Garage Statistics =====\n");
                    System.out.print("Maximum Capacity: " + parking_capacity + "\n");
                    System.out.print("Current Parked Vehicles: " + parked_vehicles.size() + "\n");
                    System.out.print("Waiting Vehicles: " + waiting_vehicles.size() + "\n");
                    System.out.print("Available Spaces: " + (parking_capacity - parked_vehicles.size()) + "\n");
                    System.out.print("Total Vehicles Parked Today: " + parked_counter + "\n");
                    System.out.print("Total Vehicles Departed Today: " + departed_counter + "\n");
                    System.out.print("Total Vehicles Processed: " + (parked_counter + departed_counter) + "\n");

                    double occupancy = (parked_vehicles.size() * 100.0) / parking_capacity;
                    System.out.print("Garage Occupancy Percentage: " + String.format("%.2f", occupancy) + "%\n");
                    break;

                case 10:
                    System.out.print("Clear Waiting Queue\n");
                    if (waiting_vehicles.isEmpty()) {
                        System.out.print("The queue is empty.\n");
                    } else {
                        System.out.print("Do you want to clear the waiting queue (Y/N): ");
                        String input6 = scanner.nextLine();
                        if (input6.equalsIgnoreCase("y")) {
                            waiting_vehicles.clear();
                            System.out.print("All waiting vehicles have been removed.\n");
                        } else {
                            System.out.print("Operation cancelled.\n");
                        }
                    }
                    break;

                case 11:
                    System.out.print("Clear Parking Garage\n");
                    if (parked_vehicles.isEmpty()) {
                        System.out.print("The garage is empty.\n");
                    } else {
                        parked_vehicles.clear();
                        System.out.print("Parking garage cleared successfully.\n");
                    }
                    break;

                case 12:
                    System.out.print("Thank you for using Smart Parking Garage.\n");
                    break;
            }
        } while (option != 12);

        System.out.print("Program terminated.\n");
        scanner.close();
    }
}