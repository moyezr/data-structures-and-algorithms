package BitManipulation;

public class EvenOrOdd {

    public static void main(String[] args) {
        int n = 3323;

        if((n & 1) == 1) {
            System.out.println("odd");
        } else{
            System.out.println("even");
        }
     }
}
