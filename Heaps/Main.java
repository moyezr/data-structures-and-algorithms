package Heaps;

public class Main {

    public static void main(String[] args) {
        int[] nums = new int[]{3, 10, 2, 4, 16, 8, 90};
        MaxHeap heap = new MaxHeap(10);

        for (int num : nums) {
            heap.insert(num);
        }

        System.out.println("DONE");
    }

}
