package Heaps;

public class Main {

    public static void main(String[] args) {
        int[] nums = new int[]{3, 10, 2, 4, 16, 8, 90};
        MaxHeap heap = new MaxHeap(nums.length);

        for (int num : nums) {
            heap.insert(num);
        }

        // Heap Sort
        while(!heap.isEmpty()) {
            System.out.println(heap.remove());
        }
    }

}
