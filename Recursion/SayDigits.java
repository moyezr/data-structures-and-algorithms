package Recursion;

public class SayDigits {

    private static String[] digits = new String[]{"Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};

    private static void sayDigits(int num) {
        if(num == 0) {
            return;
        }
        int lastDigit = num % 10;
        sayDigits(num / 10);
        System.out.print(digits[lastDigit] + " ");

    }

    public static void main(String args[]) {
        sayDigits(1234);
    }
}
