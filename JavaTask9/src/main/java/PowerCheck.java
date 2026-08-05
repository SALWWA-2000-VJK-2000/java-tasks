public class PowerCheck {
    public static  boolean isPowerOfTwo(int n){
        if(n==1){
            return true;
        }
        if (n<= 0 || n%2 !=0){
            return false;
        }
        return  isPowerOfTwo(n/2);
    }

    public static void main(String[] args){
        System.out.println("isPowerOfTwo(1)= "+ isPowerOfTwo(1));
        System.out.println("isPowerOfTwo(8)= "+ isPowerOfTwo(8));
        System.out.println("isPowerOfTwo(6)= "+ isPowerOfTwo(6));
        System.out.println("isPowerOfTwo(16)= "+ isPowerOfTwo(16));
        System.out.println("isPowerOfTwo(20)= "+ isPowerOfTwo(20));
    }
}