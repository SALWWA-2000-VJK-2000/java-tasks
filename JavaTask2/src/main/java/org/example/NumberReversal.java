package org.example;

public class NumberReversal {
    static void main() {
        Integer number= 12345 ;
        Integer reversedNumber = 0;
        Integer digit;

        System.out.println("Original Number: " + number);
        while (number>0){
            digit=number %10;
            reversedNumber = reversedNumber * 10 + digit ;
            number = number/ 10;
        }
        System.out.println("Reversed Number: " + reversedNumber);
    }

}


