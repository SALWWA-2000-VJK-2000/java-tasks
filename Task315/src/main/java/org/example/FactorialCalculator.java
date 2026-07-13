package org.example;

public class FactorialCalculator {
    static void  main() { // main method inside the class
        int number = 7; //assign value 7 to number
        int factorial =1; //assign value 1 to factorial
        int i = 1; // initialise it to 1
        while (i<=number){ //while loop with the condition i <= number
            factorial = factorial * i; // multiply factorial by i and store the result back into factorial
            i++; //increment i by 1
        }
        System.out.println("the number = " + i); //print the original number
        System.out.println("the factorial is " + factorial); //Print the calculated factorial value

    }
}
