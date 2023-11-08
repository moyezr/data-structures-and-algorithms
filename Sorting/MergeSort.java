package Sorting;

public class MergeSort {


    public static void conquer(int arr[], int si, int mid, int ei) {
        int merged[] = new int[ei - si + 1];

        int i = si;
        int j = mid + 1;
        int index = 0;
        while (i <= mid && j <= ei) {
            if (arr[j] < arr[i]) {
                merged[index++] = arr[j++];
            } else {
                merged[index++] = arr[i++];
            }
        }

        while (i <= mid && index < merged.length) {
            merged[index++] = arr[i++];
        }

        while (j <= ei && index < merged.length) {
            merged[index++] = arr[j++];
        }

        for (int k = 0; k < merged.length; k++) {
            arr[k] = merged[k];
        }
    }

    public static void divide(int arr[], int si, int ei) {

        if (si >= ei) {
            return;
        }
        int mid = si + (ei - si) / 2;

        divide(arr, si, mid);
        divide(arr, mid + 1, ei);
        conquer(arr, si, mid, ei);
    }

    public static void print(int[] arr) {
        System.out.print("[");
        for(int num: arr) {
            System.out.print(num + ", ");
        }
        System.out.print("\b\b] \n");
    }
    public static void main(String args[]) {
        int arr[] = {6, 3, 9, 5, 2, 8};
        int n = arr.length;
        System.out.print("Before sorting --> ");
        print(arr);
        divide(arr, 0, n - 1);
        System.out.print("After sorting --> ");
        print(arr);

    }
}
