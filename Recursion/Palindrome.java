package Recursion;

public class Palindrome {
    public static boolean isPalindrome(String s, int i, int j) {
        if(i >= j) return true;
        if(s.toLowerCase().charAt(i) != s.toLowerCase().charAt(j)) return false;

        return isPalindrome(s, i + 1, j - 1);
    }
    public static void main(String args[]) {
        String s = "madam";
        System.out.println(isPalindrome(s, 0, s.length() - 1));
    }
}
