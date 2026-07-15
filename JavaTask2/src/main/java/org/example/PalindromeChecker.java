package org.example;

public class PalindromeChecker {
    static void main() {
        Integer number = 1221;
        Integer originalNumber = number ;
        Integer reversedNumber =0 ;
        Integer digit ;

        while (number>0){
            digit=number %10;
            reversedNumber = reversedNumber * 10 + digit ;
            number = number/ 10;
        }
        System.out.println("Original Number: " + originalNumber);
        System.out.println("Reversed Number: " + reversedNumber);
        // Checking if n is same
        // as reverse of n

        if (reversedNumber.equals(originalNumber) ) {
            System.out.println("The number is a palindrome.");
        }else {
            System.out.println("The number is not a palindrome.");
            }
    }

}
