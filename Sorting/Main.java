package Sorting;

import java.util.Arrays;

public class Main {

    public static void print(int arr[]) {
        System.out.print("[");
        for (int num : arr) {
            System.out.print(num + ", ");
        }

        System.out.print("\b\b] \n");
    }

    public static void main(String args[]) {

        Sort sorter = new Sort();

//        int arr[] = {10, 2, 3, 4, 1, -2, 11, 12, -1, -9, 13};

            int arr[] = {4, 5, 1, 2, 3};

            sorter.insertionSortKunal(arr);
        System.out.println(Arrays.toString(arr));
//        System.out.print("Array before sorting --> ");
//        print(arr);
//        long startTime = System.nanoTime();
//        sorter.quickSort(arr);
//        long endTIme = System.nanoTime();
//        System.out.print("Array after sorting --> ");
//        print(arr);

//        System.out.println("Time Taken -> " + (endTIme - startTime));
    }
}
