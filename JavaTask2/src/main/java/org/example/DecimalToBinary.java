package org.example;

public class DecimalToBinary {
    static void main(){
        Integer number = 25;
        Integer remainder;
        String binary = "";
        Integer tempNumber = number;

        // Loop to divide the number by 2 and collect remainders
        while (tempNumber > 0) {
            remainder = tempNumber % 2;
            binary = remainder + binary;
            tempNumber = tempNumber / 2;
        }

        // Display results
        System.out.println("Decimal Number: " + number);
        System.out.println("Binary Number: " + binary);
    }
}
