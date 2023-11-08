package Stack;

import java.util.EmptyStackException;

class Node {
    public int data;
    public Node next = null;

    public Node() {
    }

    public Node(int value) {
        this.data = value;
    }
}

public class StackUsingLinkedList {
    private Node head = null;

    public void push(int value) {

        Node newNode = new Node(value);
        if(head == null) {
        head = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
    }

    public int pop() {
        if(head == null) {
            throw new EmptyStackException();
        }

        Node temp = head;
        int value = temp.data;
        head = head.next;
        temp.next = null;
        return value;
    }

    public String toString() {
        if(head == null) {
            return "Stack is Empty";
        }

        StringBuilder stringBuilder = new StringBuilder();

        Node current = head;
        while(current != null) {
            stringBuilder.append(current.data).append("\n");
            current = current.next;
        }

        return stringBuilder.toString();
    }

    public int peek() {
        if(head == null) {
            throw new EmptyStackException();
        }

        return head.data;
    }
}
