public class CheckEvenNumber {
    public static  boolean isEven(int n){
        if(n==0){
            return true;
        }
        if (n== 1 ){
            return false;
        }
        return  isEven(n-2);
    }

    // Main method to test
    public static void main(String[] args) {
        System.out.println("isEven(0) = " + isEven(0));
        System.out.println("isEven(8) = " + isEven(8));
        System.out.println("isEven(7) = " + isEven(7));
        System.out.println("isEven(15) = " + isEven(15));
        System.out.println("isEven(100) = " + isEven(100));
    }
}