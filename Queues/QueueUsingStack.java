package Queues;

import java.util.Stack;

public class QueueUsingStack {
    private Stack<Integer> s1;
    private Stack<Integer> s2;

    public QueueUsingStack() {
        this.s1 = new Stack<>();
        this.s2 = new Stack<>();
    }

    public void enqueue(int val) {
        s1.push(val);
    }

    public int dequeue() {
        if (s1.isEmpty() && s2.isEmpty()) {
            System.out.println("Queue is Empty");
            return -1;
        }

        if (s2.isEmpty()) {
            // Copy all the elements from stack 1 to stack 2.
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }

        return s2.pop();
    }

}
