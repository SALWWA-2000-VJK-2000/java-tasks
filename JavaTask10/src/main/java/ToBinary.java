public class ToBinary {
    public static String toBinary(int n) {
        if (n == 0) {
            return "0";
        }
        if (n == 1) {
            return "1";
        }
        return toBinary(n / 2) + (n % 2);
    }

    public static void main(String[] args) {
        System.out.println("toBinary(2) = " + toBinary(2));
        System.out.println("toBinary(5) = " + toBinary(5));
        System.out.println("toBinary(10) = " + toBinary(10));
        System.out.println("toBinary(1) = " + toBinary(1));
    }
}
