package org.example;

public class MultiplicationTable { //Create a Java class named MultiplicationTable
    static  void  main(){ //main method inside the class
        int base =9; //assign value 9 to base
        int result ;

        for(int i=1; i<=10; i++){ //loop that runs a counter variable from 1 to 10
            result = base * i; //calculate the product of base and the counter
            System.out.println("base x counter = " + result); //print the resulte
        }
        System.out.println("the Base is = "+ base); //Expected Output Example (for base = 9)

    }
}
