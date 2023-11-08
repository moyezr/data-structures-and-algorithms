package Recursion;

public class ReverseNumberRecursion {

    public static int reverse(int n, int sum)  {
        if(n == 0) {
            return sum;
        }

        int lastDigit = n % 10;
        sum = sum * 10 + lastDigit;

        return reverse(n / 10, sum);
    }
    public static int reverse(int n) {
        int sum = 0;
        sum = reverse(n, sum);
        return sum;
    }

    public static void main(String[] args) {
        int n = 7962;
        int reverseNumber = reverse(n);
        System.out.println(reverseNumber);
    }
}
