public class CountDigits {
    public static int countDigit(int n) {
        if (n < 10) {
            return 1 ;
        }
        return 1 + countDigit(n/10);
    }
    public static void main(String[] args){
        System.out.println("countDigits(7)= "+ countDigit(7));
        System.out.println("countDigits(45)= "+ countDigit(45));
        System.out.println("countDigits(45)= "+ countDigit(1000));
        System.out.println("countDigits(45)= "+ countDigit(999999));
    }
}

