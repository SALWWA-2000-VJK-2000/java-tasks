package org.example;

public class EvenOddCounter {
    static void main(){
        Integer start =1;
        Integer end = 10;
        Integer evenCount =0;
        Integer oddCount = 0;

        for(int i = start; i<= end; i++){
            if (i% 2==0){
                evenCount++;
            }else {
                oddCount++;
            }
        }
        System.out.println("Even Numbers Count: " + evenCount);
        System.out.println("Odd Numbers Count: " + oddCount);
    }
}
