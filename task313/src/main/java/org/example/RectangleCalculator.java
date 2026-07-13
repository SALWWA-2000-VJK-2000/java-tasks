package org.example;

public class RectangleCalculator {
    static void main() { // the main method inside the class
        Double length = 12.5;//assign value to length
        Double width = 8.0;//assign value to width
        Double area= length * width; //Calculate the area using the formula: length * width
        Double perimeter= 2 * (length + width);//Calculate the perimete
        System.out.println("Length: " + length);// print the length
        System.out.println("Width: " + width);//print the width
        System.out.println("Area: " + area);// print the calculated area
        System.out.println("Perimeter: " +perimeter);// print the calculated perimeter
    }
}
