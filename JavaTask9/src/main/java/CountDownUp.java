public class CountDownUp {
    public static void countDownUp(int n){
        if (n==0){
            return;
        }
        //printing the count-down
        System.out.println(n);
        countDownUp(n-1); //recursive function call

        //printing the count-up without 1 again
        if (n !=1){
            System.out.println(n);

        }

    }

    public static void main(String[] args){
        System.out.println("countDownUp(3): ");
        countDownUp(3);

        System.out.println("countDownUp(1): ");
        countDownUp(1);

        System.out.println("countDownUp(4): ");
        countDownUp(4);
    }
}
