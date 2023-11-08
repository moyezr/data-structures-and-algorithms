package Queues;

import java.util.Arrays;

public class PriorityQueue {
    private int size;
    private int[] items;
    private int front, rear;
    private int count;

    public PriorityQueue(int size) {
        this.items = new int[size];
        this.size = size;
        this.front = -1;
        this.rear = 0;
        this.count = 0;
    }

    public void enqueue(int val) {
        if (count == size) {
            System.out.println("Queue is full");
            return;
        }

        int i = 0;
        for (i = rear; i > 0; i--) {
            if (items[i - 1] <= val) {
                break;
            }
            if (items[i - 1] > val) {
                // Shift the element
                items[i] = items[i - 1];
            }
        }
        items[i] = val;
        rear = (rear + 1) % size;
        count++;
    }

    public int dequeue() {
        if (count == 0) {
            System.out.println("Queue is Empty");
            return -1;
        }
        front = (front + 1) % size;
        int value = items[front];
        items[front] = 0;
        count--;
        return value;
    }

    public String toString() {

        if (count == 0) {
            return "[]";
        }
        if (front == -1) {
            return Arrays.toString(items);
        }

        StringBuilder myString = new StringBuilder();
        myString.append("[");

        if (front >= rear && front + 1 < size) {
            for (int i = front + 1; i < size; i++) {
                myString.append(items[i]).append(", ");
            }
        } else {
            for (int i = rear; i < size; i++) {
                myString.append(items[i]).append(", ");
            }
        }
        for (int i = 0; i < rear; i++) {
            myString.append(items[i]).append(", ");
        }
        myString.append("\b\b").append("]");
        return myString.toString();
    }
}
