package Heaps;

public class TestMinHeap {

    public static void main(String[] args) {
        int[] nums = new int[]{3, 10, 2, 4, 16, 8, 90};
        MinHeap minHeap = new MinHeap(nums.length);

        for (int num : nums) {
            minHeap.insert(num);
        }


        while(!minHeap.isEmpty()) {
            System.out.print(minHeap.remove() + "  ");
        }

    }
}
