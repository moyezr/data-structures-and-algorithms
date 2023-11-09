package Recursion;

public class CheckIfArraySorted {

    public static boolean checkIfArraySorted(int arr[], int index) {
//        base condition
        if(index >= arr.length - 1) {
            return true;
        }

        return arr[index] < arr[index + 1] && checkIfArraySorted(arr, index + 1);
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 6, 5};


        System.out.println(checkIfArraySorted(arr, 0));

    }
}
