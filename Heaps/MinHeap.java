package Heaps;

public class MinHeap {
    private int[] items;

    private int size;

    public MinHeap(int size) {
        items = new int[size];

        this.size = 0;
    }

    public void insert(int value) {
        items[size] = value;
        size++;

        int index = size - 1;
        while (index > 0 && items[index] < getParent(index)) { // bubble up
            swapElementsWithIndex(index, getParentIndex(index));
            index = getParentIndex(index);
        }
    }

    public int remove() {
        int itemToRemove = items[0];

        items[0] = items[size - 1];
        size--;

        int index = 0;
        while(index < size && !validParent(index)) {
            int indexOfSmallestChild = getSmallestChildIndex(index);

            swapElementsWithIndex(index, indexOfSmallestChild);
            index = indexOfSmallestChild;
        }

        return itemToRemove;
    }
    public int getLeftChildIndex(int parentIndex) {
        return parentIndex * 2 + 1;
    }

    public int getRightChildIndex(int parentIndex) {
        return parentIndex * 2 + 2;
    }

    public int getParentIndex(int childIndex) {
        return (childIndex - 1) / 2;
    }

    public int getParent(int childIndex) {
        return items[getParentIndex(childIndex)];
    }

    private void swapElementsWithIndex(int index1, int index2) {
        int temp = items[index1];
        items[index1] = items[index2];
        items[index2] = temp;
    }

    private boolean hasLeftChild(int index) {
        return getLeftChildIndex(index) <= size;
    }

    private boolean hasRightChild(int index) {
        return getRightChildIndex(index) <= size;
    }

    private int getLeftChild(int index) {
        return items[getLeftChildIndex(index)];
    }

    private int getRightChild(int index) {
        return items[getRightChildIndex(index)];
    }
    private boolean validParent(int index) {
        if(!hasLeftChild(index) && !hasRightChild(index)) {
            return true;
        }

        if(!hasLeftChild(index)) return false;

        if(!hasRightChild(index)) {
            return items[index] < getLeftChild(index);
        }

        return items[index] < getLeftChild(index) && items[index] < getRightChild(index);
    }

    private int getSmallestChildIndex(int index) {
        if(!hasLeftChild(index)) return index;

        if(!hasRightChild(index)) {
            return getLeftChildIndex(index);
        }

        if(getLeftChild(index) < getRightChild(index)) {
            return getLeftChildIndex(index);
        } else {
            return getRightChildIndex(index);
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

}
