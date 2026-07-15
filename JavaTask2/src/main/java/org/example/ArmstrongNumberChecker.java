package org.example;

public class ArmstrongNumberChecker {
    static void main(){
        //initialize variables
        int number=153;
        int digit;
        int sum = 0;
        int count = 0;
        System.out.println("Number: " + number);

        // THIS  loop IS count digits
        int n = number;
        while (n > 0) {
            n = n / 10;
            count++;
        }
        // THIS  loop IS calculate Armstrong sum
        n = number;
        while (n > 0) {
            digit = n % 10;

            //digit^count
            int powerResult = 1;
            for (int i = 1; i <= count; i++) {
                powerResult = powerResult * digit;
            }
            sum = sum + powerResult;
            n = n / 10;
        }
        if (sum == number) {
            System.out.println("The number is an Armstrong number.");
        } else {
            System.out.println("The number is not an Armstrong number.");
        }
    }
}
