public class PrintRevers {
    public static String printReverse(String s){
        if(s.length()==0) {
            return "";
        }
        printReverse(s.substring(1));
        System.out.println(s.charAt(0));
        return s;
    }
    public static void main(String[] args){
        System.out.println("printReverse(\"cat\"): ");
        printReverse("cat");
        System.out.println("printReverse(\"hello\"): ");
        printReverse("hello");
    }
}
