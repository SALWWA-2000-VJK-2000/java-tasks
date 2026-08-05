public class LengthOfString {
    public static int length(String l){
        if(l.isEmpty()){
            return 0;
        }
        String sub = l.substring(1);
        return 1 + length(sub);
    }

    public static void main(String[] args){
        System.out.println("length(\"cat\") = " + length("cat"));
        System.out.println("length(\"hello\") = " + length("hello"));
        System.out.println("length(\"\") = " + length(""));
        System.out.println("length(\"a\") = " + length("a"));
    }
}
