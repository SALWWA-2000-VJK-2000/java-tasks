package org.example;

public class DigitFrequencyCounter {
    static  void main(){
        int number = 122333;
        int targetDigit = 3;
        int count = 0;
        int digit;
        int tempNumber = number;

        // Loop to extract digits
        while (tempNumber > 0) {
            digit = tempNumber % 10;
            if (digit == targetDigit) {
                count++;
            }
            tempNumber = tempNumber / 10;
        }

        // Display results
        System.out.println("Number: " + number);
        System.out.println("Target Digit: " + targetDigit);
        System.out.println("Frequency: " + count);
    }
}
