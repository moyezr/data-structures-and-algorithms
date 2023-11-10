package Recursion;

public class RemoveAllAs {

    public static String removeAllAs(String s, int index) {
        if(s.length() == index) return "";

        char ch = s.charAt(index);

        if(ch == 'a') {
            return "" + removeAllAs(s, index + 1);
        } else {
            return ch + removeAllAs(s, index + 1);
        }
    }

    public static void main(String[] args) {
        String s = "baccad";

        System.out.println(removeAllAs(s, 0));
    }
}
