package Heaps;

import java.util.Arrays;

public class Heapify {

    private static void heapify(int[] arr, int index) {
        int smallestIndex = index;
        int size = arr.length;

        int lci = index * 2 + 1;
        int rci = index * 2 + 2;

        if(lci < size && arr[index] > arr[lci]) {
            smallestIndex = lci;
        }

        if(rci < size && arr[index] > arr[rci]) {
            smallestIndex = rci;
        }

        if(smallestIndex == index ) {
            return;
        }

        // swap
        int t = arr[index];
        arr[index] = arr[smallestIndex];
        arr[smallestIndex] = t;

        heapify(arr, smallestIndex);
    }
    public static int[] buildMinHeap(int[] arr) {
        int size = arr.length;

        for(int i = size - 1; i >=0; i--) {
            heapify(arr, i);
        }

        return arr;
    }

    public static void main(String[] args) {
        int nums[] = new int[]{9, 3, 2, 6, 7};

        buildMinHeap(nums);

        System.out.println(Arrays.toString(nums));
    }

}
