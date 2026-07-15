package org.example;

public class MultiplicationCalculator {
    static void  main(){
        Integer start = 1;
        Integer end = 5;
        Integer result = 1;

        // Loop to multiply numbers from start to end
        for (int i = start; i <= end; i++) {
            result = result * i; // Multiply step by step
        }

        // Display the final result
        System.out.println("Multiplication Result: " + result);
    }
}
