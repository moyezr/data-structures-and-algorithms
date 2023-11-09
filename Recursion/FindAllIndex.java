package Recursion;

import java.util.ArrayList;

public class FindAllIndex {

    public static ArrayList<Integer> findAllIndex(int arr[], int target, int index) {
        ArrayList<Integer> list = new ArrayList<>();
        if(index == arr.length) {
            return list;
        }

        if(arr[index] == target) {
            list.add(index);
        }

        ArrayList<Integer> answerFromBelowCalls = findAllIndex(arr, target, index + 1);
        list.addAll(answerFromBelowCalls);

        return list;
    }
    public static void main(String[] args) {
        int arr[] = {1, 3, 4, 4 ,8};
        System.out.println(findAllIndex(arr, 4, 0));

    }
}
