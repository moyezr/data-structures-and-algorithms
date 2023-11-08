package Arrays;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String args[]) {
        MyArray arr = new MyArray(15);
        arr.insert(1); // 0
        arr.insert(2); // 1
        arr.insert(3); // 2
        arr.insert(4); // 3
        arr.insert(5); // 4
        arr.insert(6); // 5
        System.out.println("Original Array -> " + arr.toString()); // [1, 2, 3, 4, 5, 6]
//        arr.removeAt(3); // removes 4
//        System.out.println("After removing an element -> " + arr.toString()); // should give [1, 2, 3, 5, 6]

        System.out.println("The maximum value in the array is --> " + arr.max());
        System.out.println("The minimum value in the array is --> " + arr.min());

        arr.reverse();
        System.out.println("Reversed Array -> " + arr.toString());
    }
}
