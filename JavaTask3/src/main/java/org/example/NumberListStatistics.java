package org.example;

import java.util.ArrayList;
import java.util.List;

public class  NumberListStatistics {
    static void main(){

        List<Integer> numbers = new ArrayList<>();

        // Add at least 20 student names to the list
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);
        numbers.add(6);
        numbers.add(7);
        numbers.add(8);
        numbers.add(9);
        numbers.add(10);
        numbers.add(0);
        numbers.add(-1);
        numbers.add(-2);
        numbers.add(-3);
        numbers.add(-4);
        numbers.add(-5);
        numbers.add(-6);
        numbers.add(-7);
        numbers.add(-8);
        numbers.add(-9);
        numbers.add(-10);


        //Create variables
        Integer sum=0;
        Integer evenCount=0;
        Integer oddCount=0;
        Integer positiveNumber=0;
        Integer negativeNumber=0;
        Integer largest = numbers.get(0);   //  first number
        Integer smallest = numbers.get(0);  //  first number

        // Loop through all numbers in the list
        for (int num : numbers) {
            // Add to sum
            sum += num;

            // Check even or odd
            if (num % 2 == 0) {
                evenCount++;
            } else {
                oddCount++;
            }

            // Check positive, negative, or zero
            if (num > 0) {
                positiveNumber++;
            } else if (num < 0) {
                negativeNumber++;
            }

            // Find largest number
            if (num > largest) {
                largest = num;
            }

            // Find smallest number
            if (num < smallest) {
                smallest = num;
            }
        }

        // Calculate average
        double average = (double) sum / numbers.size();

        // Display all numbers
        System.out.println("Numbers in the List:");
        for (int num : numbers) {
            System.out.print(num + " ");
        }
        System.out.println(); // New line

        // Display results
        System.out.println("Sum of Numbers: " + sum);
        System.out.println("Average Value: " + average);
        System.out.println("Largest Number: " + largest);
        System.out.println("Smallest Number: " + smallest);
        System.out.println("Count of Even Numbers: " + evenCount);
        System.out.println("Count of Odd Numbers: " + oddCount);
        System.out.println("Count of Positive Numbers: " + positiveNumber);
        System.out.println("Count of Negative Numbers: " + negativeNumber);
    }


    }

