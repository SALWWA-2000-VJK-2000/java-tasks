public class CountDigit {
    public static int countDigit(int number, int target){
        if(number==0){
            return 0;
        }
        int lastDigit = number %10;
        int count = 0;
        if (lastDigit==target){
            count =1;
        }
        return  count +countDigit(number /10, target);
    }
    public static void main(String[] args) {
        System.out.println("countDigit(2222, 2) = " + countDigit(2222, 2));
        System.out.println("countDigit(12321, 1) = " + countDigit(12321, 1));
        System.out.println("countDigit(5050, 0) = " + countDigit(5050, 0));
        System.out.println("countDigit(789, 6) = " + countDigit(789, 6));
    }
}