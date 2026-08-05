public class NumberVowels {
    public static int countVowels(String c){
        if(c.equals("")){
            return 0;
        }
        char first= Character.toLowerCase(c.charAt(0));
        int count= 0;
        if(first == 'a'|| first== 'e' || first=='i'|| first == 'o'|| first =='u'){
            count =1;
        }else {
            count =0;
        }
        return count +countVowels(c.substring(1));
    }

    public static void main(String[] args) {
        System.out.println("countVowels(\"hello\") = " + countVowels("hello"));
        System.out.println("countVowels(\"programming\") = " + countVowels("programming"));
        System.out.println("countVowels(\"sky\") = " + countVowels("sky"));
        System.out.println("countVowels(\"aeiou\") = " + countVowels("aeiou"));       
    }
}
