package org.example;
import java.util.Scanner;

public class TriangleCalculator {
    static void main(){
        Scanner scanner = new Scanner(System.in);

        double area;
        double perimeter;
        String triangleType;

        // Prompting for base and height
        System.out.print("Enter the triangle's base: ");
        double base = scanner.nextDouble();

        System.out.print("Enter the triangle's height: ");
        double height = scanner.nextDouble();

        // Prompting for the lengths of the three sides
        System.out.print("Enter the length of side 1: ");
        double side1 = scanner.nextDouble();

        System.out.print("Enter the length of side 2: ");
        double side2 = scanner.nextDouble();

        System.out.print("Enter the length of side 3: ");
        double side3 = scanner.nextDouble();

        if (base <= 0 || height <= 0 || side1 <= 0 || side2 <= 0 || side3 <= 0) {
            System.out.println("Invalid input. All values must be greater than zero.");
        } else {
            // Calculate area using formula (base * height) / 2
            area = (base * height) / 2;

            // Calculate perimeter by adding all sides
            perimeter = side1 + side2 + side3;

            // Determine triangle type
            if (side1 == side2 && side2 == side3) {
                triangleType = "Equilateral Triangle";
            } else if (side1 == side2 || side1 == side3 || side2 == side3) {
                triangleType = "Isosceles Triangle";
            } else {
                triangleType = "Scalene Triangle";
            }
            // Display results
            System.out.println("Base: " + base);
            System.out.println("Height: " + height);
            System.out.println("Side 1: " + side1);
            System.out.println("Side 2: " + side2);
            System.out.println("Side 3: " + side3);
            System.out.println("Area: " + area);
            System.out.println("Perimeter: " + perimeter);
            System.out.println("Triangle Type: " + triangleType);
        }
        scanner.close();
    }
}
