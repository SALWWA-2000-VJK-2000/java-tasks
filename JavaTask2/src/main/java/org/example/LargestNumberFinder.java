package org.example;

import java.util.List;

public class LargestNumberFinder {
    static void main(){
        List<Integer> number = List.of(80,0,89,88);
        Integer largest = number.get(0);
        for (int i=1; i<number.size(); i++){
            if(number.get(i) > largest){
                largest= number.get(i);
            }
        }
        // Display the largest number
        System.out.println("Largest Number: " + largest);
    }
}
