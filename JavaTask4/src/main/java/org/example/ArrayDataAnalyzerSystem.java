package org.example;
import java.util.Arrays;
import java.util.Scanner;
public class ArrayDataAnalyzerSystem {
    static public void main(){

        //Create and Initialize Array
        int[] numbers = {45, 12, -5, 90, 33, 12, 0, 67, -20, 88, 45, 100, 7, -3, 55};

        //Display Array Information
        //Total number of elements.
        System.out.println("Total number of elements: "+ numbers.length);

        //First element
        System.out.println("First element: "+ numbers[0]);

        //Last element
        System.out.println("Last element: "+ numbers[numbers.length - 1]);

        //All elements with their indexes
        for (int i=0; i< numbers.length; i++ ){
            System.out.println("Index " + i + " = " + numbers[i]);
        }

        //Array Statistics
        //Sum of all numbers
        int sum=0;
        for (int number : numbers){
            sum += number; //sum =sum+ number
        }
        System.out.println("Sum= "+ sum);

        //Average value
        double average = (double) sum/numbers.length;
        System.out.println("Average=  "+ average);

        //Largest number
        int large = numbers[0];
        for (int number : numbers){
            if (number> large){
                large=number;
            }
        }
        System.out.println("Maximum= "+ large);

        //Smallest number
        int small =numbers[0];
        for (int number: numbers){
            if(number< small){
                small = number;
            }
        }
        System.out.println("Minimum = "+ small);


        // Number Classification
        //Count of positive numbers
        int pos = 0;
        for (int number : numbers){
            if(number>0){
                pos++;
            }
        }
        System.out.println("Positive Numbers: " + pos);

        //Count of negative numbers
        int neg= 0;
        for (int number : numbers){
            if (number<0){
                neg++;
            }
        }
        System.out.println("Negative Numbers: " + neg);

        //Count of zero values
        int zero=0;
        for (int number : numbers){
            if (number==0){
                zero++;
            }
        }
        System.out.println("Zeros: " + zero);

        //Count of even numbers
        //Count of odd numbers.
        int evenCount=0;
        int oddCount=0;
        for (int number: numbers){
            if (number % 2 == 0) {
                evenCount++;
            } else {
                oddCount++;
            }
        }
        System.out.println("Even Numbers:" + evenCount);
        System.out.println("Odd Numbers: " + oddCount);

        //Search System
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number to search: ");
        int target =scanner.nextInt();

        boolean found = false;
        int firstIndex = -1;
        int occurrences = 0;

        // Loop through the array
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == target) {
                found = true;
                if (firstIndex == -1) {
                    firstIndex = i;   // store the first index
                }
                occurrences++;         // count how many times it appears
            }
        }
        // Display results
        if (found) {
            System.out.println("Number found.");
            System.out.println("First index: " + firstIndex);
            System.out.println("Occurrences: " + occurrences);
        } else {
            System.out.println("Number not found.");
        }


        // Update Array Values
        System.out.println("Enter index to update: ");
        int updatedIndex = scanner.nextInt();
        if(updatedIndex>=0 && updatedIndex< numbers.length){
            System.out.println("Enter new value: ");
            int newValue =scanner.nextInt();
            numbers[updatedIndex]= newValue;
            System.out.println("Updated Array: "+ Arrays.toString(numbers));
        }else{
            System.out.println("Invalid index");
        }

        // Reverse Array
        System.out.println("\n Original: \n"+ Arrays.toString((numbers)));
        System.out.println(" Reverse: ");
        for(int i =numbers.length -1 ; i>=0; i--){
            System.out.print(numbers[i] +" ");
        }

        // Sorting and Comparison
        int[] copy = Arrays.copyOf(numbers, numbers.length);  // copy first, keep original safe
        Arrays.sort(copy);
        System.out.println("\nSorted: " + Arrays.toString(copy));
        System.out.println("Smallest value:" + copy[0]);
        System.out.println("Smallest value:" + copy[copy.length - 1]);

        scanner.close();
    }
}