package org.example;
import java.util.Scanner;

public class TrapezoidCalculator {
    static void main() {
        Scanner scanner = new Scanner(System.in);

        double area=0;
        double perimeter=0;
        String classification;

        // Prompting for 2 bases and height
        System.out.print("Enter the  base 1: ");
        double base1 = scanner.nextDouble();

        System.out.print("Enter the  base 2: ");
        double base2 = scanner.nextDouble();

        System.out.print("Enter the height: ");
        double height = scanner.nextDouble();

        // Prompting for the legs
        System.out.print("Enter  leg 1: ");
        double leg1 = scanner.nextDouble();

        System.out.print("Enter leg 2: ");
        double leg2 = scanner.nextDouble();


        if (base1 <= 0 || base2 <= 0 || height <= 0 || leg1 <= 0 || leg2 <= 0) {
            System.out.println("Invalid input. All measurements must be greater than zero.");
        } else {
            // Calculate area using formula ((base1 + base2) * height) / 2
            area = ((base1 + base2) * height) / 2;

            // Calculate perimeter by adding all sides
            perimeter = base1 + base2 + leg1 + leg2;
        }

        if(perimeter<30){
            classification=" Small Trapezoid ";
        } else if (perimeter<=60) {
            classification = " Medium Trapezoid ";
        }else {
            classification="  Large Trapezoid  ";
        }
        // Display results
        System.out.println("Base 1: " + base1);
        System.out.println("Base 2: " + base2);
        System.out.println("Height: " + height);
        System.out.println("leg 1: " + leg1);
        System.out.println("leg 2: " + leg2);
        System.out.println("Area: " + area);
        System.out.println("Perimeter: " + perimeter);
        System.out.println("Classification: " + classification);

        scanner.close();

    }
}
