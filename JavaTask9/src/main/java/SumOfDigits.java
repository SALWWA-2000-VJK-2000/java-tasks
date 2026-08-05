public class SumOfDigits {
    public static int sumDigits(int n) {
        if(n==0){
            return 0;
        }
        int lastDigit = n%10;
         return lastDigit + sumDigits(n/10);
    }

    public static void main(String[] args){
        System.out.println("sumDigits(5)= "+ sumDigits(5));
        System.out.println("sumDigits(123)= "+ sumDigits(123));
        System.out.println("sumDigits(999)= "+ sumDigits(999));
        System.out.println("sumDigits(4021)= "+ sumDigits(4021));
    }
}