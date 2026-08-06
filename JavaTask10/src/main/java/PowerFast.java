public class PowerFast {
    public static int power(int base, int exponent) {
        if (exponent == 0) {
            return 1;
        }
        if (exponent % 2 == 0) {
            int halfPower = power(base, exponent / 2);
            return halfPower * halfPower;
        } else {
            return base * power(base, exponent - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println("power(2, 10) = " + power(2, 10));
        System.out.println("power(3, 4) = " + power(3, 4));
        System.out.println("power(5, 3) = " + power(5, 3));
        System.out.println("power(2, 0) = " + power(2, 0));
    }
}