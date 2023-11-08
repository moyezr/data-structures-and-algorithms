package Sorting;

public class Sort {

    public int[] bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j + 1] < arr[j]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }

        }

        return arr;
    }

    public int[] selectionSort(int arr[]) {
        for(int i = 0; i < arr.length - 1; i++) {
            int min = arr[i];
            int pos = i;
            for(int j = i + 1; j < arr.length; j++) {
                if(arr[j] < min){
                    min = arr[j];
                    pos = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[pos];
            arr[pos] = temp;
        }

        return arr;
    }

    public void insertionSort(int arr[]) {
        for(int i = 1; i < arr.length; i++) {
            int currentElement = arr[i];

            int j = i - 1;

            while(j >= 0 && currentElement < arr[j]) {
                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = currentElement;
        }
    }

    public void mergeSort(int[] arr) {

        if(arr.length < 2) return;

        int middle = arr.length / 2;

        int[] left = new int[middle];
        int[] right = new int[arr.length - middle];

        int index = 0;
        for(int i = 0; i < middle; i++) {
            left[i] = arr[index++];
        }

        for(int i = middle; i < arr.length; i++) {
            right[i - middle] = arr[index++];
        }

        // Sort
        mergeSort(left);
        mergeSort(right);

        //Merge
        merge(left, right, arr);
    }

    private static void merge(int[] left, int[] right, int[] arr) {
        int index = 0;
        int i = 0;
        int j = 0;

        while(i < left.length && j < right.length) {
            if(left[i] < right[j]) {
                arr[index++] = left[i++];
            } else {
                arr[index++] = right[j++];
            }
        }

        while(i < left.length) {
            arr[index++] = left[i++];
        }

        while(j < right.length) {
            arr[index++] = right[j++];
        }
    }

    private static int getBoundary(int[] arr, int start, int end) {
        int pivot = arr[end];
        int boundary = start - 1;

        for(int i = start; i <= end; i++) {
            if(arr[i] <= pivot) {
                // Swapping
                int temp = arr[++boundary];
                arr[boundary] = arr[i];
                arr[i] = temp;
            }
        }

        return boundary;
    }
    private static void quickSort(int[] arr, int start, int end) {
        if(start >= end) return;

        int boundary = getBoundary(arr, start, end);

        quickSort(arr, start, boundary - 1);
        quickSort(arr, boundary + 1, end);
    }
    public void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

}
