public class CountZeros {
    public static int countZeros(int number) {
        if (number == 0) {
            return 1;
        }
        if (number < 10) {
            return (number == 0) ? 1 : 0;
        }
        int lastDigit = number % 10;
        int count = 0;
        if (lastDigit == 0) {
            count = 1;
        }
        return count + countZeros(number / 10);
    }

    public static void main(String[] args) {
        System.out.println("countZeros(1020) = " + countZeros(1020));     // 2
        System.out.println("countZeros(5000) = " + countZeros(5000));     // 3
        System.out.println("countZeros(123) = " + countZeros(123));       // 0
        System.out.println("countZeros(908070) = " + countZeros(908070)); // 3
        System.out.println("countZeros(0) = " + countZeros(0));           // 1
    }
}