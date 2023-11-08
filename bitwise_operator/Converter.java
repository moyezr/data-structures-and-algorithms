package bitwise_operator;

public class Converter {

    String toBinary(int n) {
        String convertedNumber = "";
        while (n > 0) {
            int lastBit = n & 1;
            convertedNumber = lastBit + convertedNumber;
            n = n >> 1;
        }
    return convertedNumber;
    }

    int toDecimal(int n) {
        String temp = String.valueOf(n);
        int dec = 0;
        int i = 0;
        int lastDigit = 0;
        for( i = 0; i < temp.length() ; i++) {
            lastDigit = n % 10;
            if(lastDigit  == 1) {
                dec += (int) Math.pow(2, i);
            }
            n = n / 10;
        }
        return dec;

    }

    public static void main(String[] args) {
        Converter obj = new Converter();

        System.out.println(obj.toBinary(5));
        System.out.println(obj.toDecimal(1010));
    }


}
