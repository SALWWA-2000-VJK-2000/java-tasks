package org.example;

public class EvenNumberAnalyzer {
    static void main(){
        Integer limit=20 ;
        Integer count = 0;
        Integer sum= 0;
        for (int i= 1; i<=limit; i++){ // loop to iterate from 1 to limit
            if (i%2==0){  //check if the current number is even using the modulo operator (%)
                System.out.println(i); //Print the number on a new line
                sum = sum+ i;//Add the number to the sum variable
                count= count+1; //Increase the count variable by 1
            }
        }
        System.out.println("we have " + count+ " even numbers ");//print the total count of even numbers
        System.out.println("the sum of the all even numbers is = " +sum);//print the total sum of all even numbers

    }
}
