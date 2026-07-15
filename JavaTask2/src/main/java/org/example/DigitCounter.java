package org.example;

public class DigitCounter {
    static  void main(){
        Integer number = 123456;
        Integer count = 0 ;
        System.out.println("Number: " + number);
        while ( number>0){
            number =number/10;
            count++;
        }
        // Display results
        System.out.println("Number of digits: " + count);



    }
}
