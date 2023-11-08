package bitwise_operator;

public class ReverseInteger {

    public int reverse(int x) {
        String reversedNumber = "";
        int lastDigit = 0;
        if (x == 0) {
            return 0;
        }
        while (x != 0) {
            lastDigit = x % 10;
            System.out.println("Last Digit --> " + lastDigit);
            reversedNumber += lastDigit;
            x = x / 10;
        }

        int reversedNumberInInteger = Integer.parseInt(reversedNumber);

        return reversedNumberInInteger;
    }

    public static void main(String args[]) {

        ReverseInteger obj = new ReverseInteger();

        System.out.println(obj.reverse(543));

    }


}
