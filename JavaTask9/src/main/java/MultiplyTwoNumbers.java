public class MultiplyTwoNumbers {
    public static int muptiply(int a, int b){

        if (b==0){
            return 0;
        }
        return  a + muptiply(a, b-1);
    }
    public static void  main(String[] args){
        System.out.println("multiply(3, 4): " +muptiply(3,  4));

        System.out.println("multiply(5, 2): "+ muptiply(5, 2));

        System.out.println("multiply(0, 9): " +muptiply(0, 9));

        System.out.println("multiply(6, 1): "+muptiply(6, 1));

    }
}