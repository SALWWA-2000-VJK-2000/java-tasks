public class printNumbers {
    public static void printNumbers(int n){
        if(n==0){
            return;
        }
        //System.out.println(n);

        printNumbers(n-1);
        System.out.println(n);
    }

    public static void main(String[] args) {
        System.out.println("printUp(3): ");
        printNumbers(3);

        System.out.println("printUp(5): ");
        printNumbers(5);
    }

}
