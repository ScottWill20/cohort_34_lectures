
public class Pallindrome {

    public static void main(String[] args) {
        System.out.println(isPalindrome("kayak"));
        System.out.println(isPalindrome("bike"));
        System.out.println(isPalindrome("madam"));
    }

    public static boolean isPalindrome(String word) {

        int i = 0;
        int x = word.length() - 1;
        while (i < x) {
            if (!(word.charAt(i) == word.charAt(x))) {
                return false;
            }
            i++;
            x--;
        }
        return true;
    }
}
