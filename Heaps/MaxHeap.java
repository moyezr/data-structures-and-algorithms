package Heaps;


public class MaxHeap {

    private int[] items;
    private int size;

    public MaxHeap(int size) {
        this.items = new int[size];
        this.size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
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
    public int remove() {
        int itemToRemove = items[0];

        items[0] = items[size - 1];
        size--;

        // Bubble Down
        int index = 0;
        while(index < size && !validParent(index)) {
            int indexOfLargestChild = getLargestChildIndex(index);

            swapElementsWithIndex(index, indexOfLargestChild);
            index = indexOfLargestChild;
        }

        return itemToRemove;
    }

    private int getLargestChildIndex(int index) {
        if(!hasLeftChild(index)) return index;
        if(!hasRightChild(index)) {
            getLeftChildIndex(index);
        }

        if(getLeftChild(index) > getRightChild(index)) {
            return getLeftChildIndex(index);
        } else {
            return getRightChildIndex(index);
        }
    }

    private boolean validParent(int index) {
        if(!hasLeftChild(index) && !hasRightChild(index)) {
            return true;
        }

        if(!hasLeftChild(index)) return false;

        if(!hasRightChild(index)) {
            return items[index] > getLeftChild(index);
        }

        return items[index] > getLeftChild(index) && items[index] > getRightChild(index);
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

    private int getLeftChildIndex(int index) {
        return index * 2 + 1;
    }
    private int getRightChildIndex(int index) {
        return index * 2 + 2;
    }

    private int getRightChild(int index) {
        return items[getRightChildIndex(index)];
    }

    private int getLeftChild(int index) {
        return items[getLeftChildIndex(index)];
    }

    private boolean hasLeftChild(int index) {
        return getLeftChildIndex(index) <= size;
    }

    private boolean hasRightChild(int index) {
        return getRightChildIndex(index) <= size;
    }

}
