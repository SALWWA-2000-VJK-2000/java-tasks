public class CheckCharacter {
    public static boolean contains(String str, char ch) {

        if (str.length() == 0) {
            return false;
        }

        if (str.charAt(0) == ch) {
            return true;
        }

        return contains(str.substring(1), ch);
    }

    public static void main(String[] args) {
        System.out.println("contains(\"hello\", 'e') = " + contains("hello", 'e'));
        System.out.println("contains(\"world\", 'z') = " + contains("world", 'z'));
        System.out.println("contains(\"java\", 'a') = " + contains("java", 'a'));
        System.out.println("contains(\"\", 'x') = " + contains("", 'x'));
    }
}