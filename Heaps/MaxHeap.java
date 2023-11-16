package Heaps;


public class MaxHeap {

    private int[] items;
    private int size;

    public MaxHeap(int size) {
        this.items = new int[size];
        this.size = 0;
    }

    public void insert(int value) {
        // Insert the element at available slot

        items[size] = value;
        size++;

        // Bubble up
        int index = size - 1;
        while(index > 0 && items[index] > getParent(index)) {
            // Swap them
            swapElementsWithIndex(index, getParentIndex(index));
            index = getParentIndex(index);
        }
    }

    private int getParentIndex(int childIndex) {
        return (childIndex - 1) / 2;
    }

    private int getParent(int childIndex) {
        return items[getParentIndex(childIndex)];
    }

    private void swapElementsWithIndex(int index1, int index2) {
        int temp = items[index1];
        items[index1] = items[index2];
        items[index2] = temp;
    }
}
