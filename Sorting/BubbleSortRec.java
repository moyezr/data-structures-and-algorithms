package Sorting;

import java.sql.SQLOutput;

public class BubbleSortRec {

    static int[] sortRec(int arr[], int index) {

        if(index == arr.length - 1) {
            return arr;
        }

        if(arr[index] > arr[index + 1]){
            int temp = arr[index];
            arr[index] = arr[index + 1];
            arr[index + 1] = temp;
        }

        return sortRec(arr, index + 1);

    }

    static void print(int arr[]) {
        System.out.print("[");
        for(int num: arr) {
            System.out.print(num + ", ");
        }
        System.out.print("\b\b]");

    }

    public static void main(String[] args) {
        int arr[] = {1, 3, 2, 5, 8};
        sortRec(arr, 0);
        print(arr);
    }
}
