package Searching;

public class Main {

    public static int linearSearch(int[] arr, int searchItem) {
        for(int i =0; i< arr.length; i++)   {
            if(arr[i] == searchItem) {
                return i;
            }
        }
        return -1;
    }

    public static int binarySearch(int[] arr, int searchItem) {
        int low = 0;
        int high = arr.length -1;
        int mid;
        while(low <= high) {
            mid = (low + high) / 2;
            if(arr[mid] == searchItem) {
                return mid;
            }
            if(arr[mid] > searchItem) {
                high--;
            } else {
                low++;
            }
        }

        return -1;
    }

    public static int recBinarySearch(int[] arr, int low, int high, int searchItem) {
        if(low > high) return -1;
        int mid = (low + high) / 2;

        if(arr[mid] == searchItem) return mid;
        else if(arr[mid] > searchItem) return recBinarySearch(arr, low, high -1, searchItem);
        else return recBinarySearch(arr, low + 1, high, searchItem);
    }


    public static void main(String args[]) {
        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8};

        int foundPosition = exponentialSearch(arr, 3);

        System.out.println("Element found at position " + foundPosition);

        if(foundPosition == -1) {
            System.out.println("Element not found");
        } else {
            System.out.println("Element found at index " + foundPosition);
        }
    }

    public static int exponentialSearch(int[] arr, int val) {
        if(arr[0] == val) return 0;

        int currentIndex = 1;

        while(currentIndex < arr.length && arr[currentIndex] <= val) {
            currentIndex = currentIndex * 2;
        }

        if(currentIndex >= arr.length) {
            currentIndex = arr.length - 1;
        }

        return recBinarySearch(arr, currentIndex / 2, currentIndex, val);
    }
}
