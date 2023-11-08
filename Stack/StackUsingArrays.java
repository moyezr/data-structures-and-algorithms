package Stack;

import java.util.EmptyStackException;

public class StackUsingArrays {

    private int top;
    private int size;
    private int[] items;

    public StackUsingArrays() {
        top = 0;
        size = 5;
        items = new int[5];
    }

    public StackUsingArrays(int size) {
        top = 0;
        this.size = size;
        items = new int[size];
    }

    public void push(int value) {
        if (top == size) throw new StackOverflowError();
        items[this.top] = value;
        this.top++;
    }

    public int pop() {
        if (top <= 0) throw new EmptyStackException();
        this.top--;
        int value = items[top];
        items[top] = 0;
        return value;
    }

    public int size() {
        return top;
    }

    public boolean isEmpty() {
        if (this.top == 0) return true;
        else return false;
    }

    public int peek() {
        if(top <= 0) {
            return -9999;
        }

        return items[top - 1];
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = size - 1; i >= 0; i--) {
            stringBuilder.append(items[i]).append("\n");
        }

        return stringBuilder.toString();

    }

}
