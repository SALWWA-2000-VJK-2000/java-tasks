public class SumEven {
    public static int sumEven(int n){
        if(n<=0){
            return 0;
        }
        int add=0;
        if(n%2 ==0){
            add= n;
        }
        return  add + sumEven(n-1);
    }
    public static void main(String[] args){
        System.out.println("sumEven(2) = " + sumEven(2));
        System.out.println("sumEven(6) = " + sumEven(6));
        System.out.println("sumEven(10) = " + sumEven(10));
        System.out.println("sumEven(1) = " + sumEven(1));
    }
}

