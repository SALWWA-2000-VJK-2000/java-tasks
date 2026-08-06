public class RemoveCharacter {
    public static String removeChar(String s, char ch) {
        if (s.equals("")) {
            return "";
        }
        char first = s.charAt(0);

        if (first == ch) {
            return removeChar(s.substring(1), ch);
        } else {
            return first + removeChar(s.substring(1), ch);
        }
    }
    public static void main(String[] args) {
        System.out.println("removeChar(\"banana\", 'a') = " + removeChar("banana", 'a'));
        System.out.println("removeChar(\"hello\", 'l') = " + removeChar("hello", 'l'));
        System.out.println("removeChar(\"mississippi\", 's') = " + removeChar("mississippi", 's'));
        System.out.println("removeChar(\"abc\", 'z') = " + removeChar("abc", 'z'));
    }
}