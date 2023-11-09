package Sorting;

import java.sql.SQLOutput;

public class BubbleSortRec {

    static void sortRec(int arr[], int r, int c) {

        if (r == 0) {
            return;
        }

        if (c < r) {
            if (arr[c] > arr[c + 1]) {
//              swap
                int temp = arr[c];
                arr[c] = arr[c + 1];
                arr[c + 1] = temp;
            }
            sortRec(arr, r, c + 1);
        } else {
            sortRec(arr, r - 1, 0);
        }

    }

    static void print(int arr[]) {
        System.out.print("[");
        for (int num : arr) {
            System.out.print(num + ", ");
        }
        System.out.print("\b\b]");

    }

    public static void main(String[] args) {
        int arr[] = {1, 3, 2, 5, 8, -4, -2, 10};
        print(arr);
        sortRec(arr, arr.length - 1, 0);
        print(arr);
    }
}
