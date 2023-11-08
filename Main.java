import java.util.Scanner;

public class Main {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            System.out.println("Enter a number");
            int n = sc.nextInt();

            long startTime = System.nanoTime();
            if(n % 2 == 0) {
                System.out.println("Even");
            } else {
                System.out.println("Odd");
            }
            long endTime = System.nanoTime();

            System.out.println("Time Taken " + (endTime - startTime));

            long startTimeWithBit = System.nanoTime();
            if((n & 1) == 0) {
                System.out.println("Even");
            } else {
                System.out.println("Odd");
            }
            long endTimeWithBit = System.nanoTime();

            System.out.println("Time Taken WIth Bit" + (endTimeWithBit - startTimeWithBit));


        }

}