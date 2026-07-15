package org.example;

public class FibonacciSequence {
    static void main() {
        Integer first = 0;
        Integer second = 1;
        for (int i = 1; i <= 15; i++) {
            System.out.print(first + " ");
            Integer next = first + second;
            first = second;
            second = next;
        }
    }
}
