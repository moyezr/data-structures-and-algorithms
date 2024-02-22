package BitManipulation;

public class NumberOf1Bits {

    public static void main(String[] args) {
        System.out.println(hammingWeight(5));
    }
    public static int hammingWeight(int n) {
        int count = 0;
        for(int i = 31; i >= 0; i--) {
            if(((n >> i) & 1) == 1)
                count++;
        }

        return count;
    }

    public static int alternateSolution(int n) {
        return Integer.bitCount(n);
    }
}


