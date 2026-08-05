
public class CheckWord {
    public static  boolean isPalindrome(String l){
        if(l.length()<=1){
            return true;
        }
        if (l.charAt(0) != l.charAt(l.length()-1) ){
            return false;
        }
        return  isPalindrome(l.substring(1, l.length()-1));
    }

    public static void main(String[] args) {
        System.out.println("isPalindrome(\"level\") = " + isPalindrome("level"));
        System.out.println("isPalindrome(\"madam\") = " + isPalindrome("madam"));
        System.out.println("isPalindrome(\"hello\") = " + isPalindrome("hello"));
        System.out.println("isPalindrome(\"a\") = " + isPalindrome("a"));

    }
}