public class CountUpper {
    public static int countUpper(String s) {
        if (s.equals("")) {
            return 0;
        }

        char first = s.charAt(0);
        int count = 0;
        if (Character.isUpperCase(first)) {
            count = 1;
        }

        return count + countUpper(s.substring(1));
    }

    public static void main(String[] args) {
        System.out.println("countUpper(\"Hello\") = " + countUpper("Hello"));
        System.out.println("countUpper(\"JavaProgram\") = " + countUpper("JavaProgram"));
        System.out.println("countUpper(\"ABC\") = " + countUpper("ABC"));
        System.out.println("countUpper(\"lower\") = " + countUpper("lower"));
    }
}