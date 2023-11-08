package LinkedList;

import Stack.StackUsingLinkedList;

public class TestingStackUsingLinkedList {
    public static void main(String args[]) {
        StackUsingLinkedList myStack = new StackUsingLinkedList();

        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        myStack.push(4);
        myStack.push(5);
        System.out.println(myStack.peek());

        System.out.println(myStack);

        myStack.pop();

        System.out.println(myStack);
        System.out.println(myStack.peek());

    }
}
