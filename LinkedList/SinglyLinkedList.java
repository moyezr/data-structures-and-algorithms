package LinkedList;

class Node {
    public int data;
    public Node next = null;

    public Node() {
    }

    public Node(int value) {
        this.data = value;
    }
}

public class SinglyLinkedList {
    private Node head;
    private Node tail;

    public SinglyLinkedList() {
        head = null;
        tail = null;
    }

    public void insert(int value) {
        Node node = new Node(value);
        if (isEmpty()) {
            head = tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
    }

    public String toString() {
        if (head == null) {
            return "Your list is empty";
        }
        Node current = head;
        StringBuilder result = new StringBuilder();
        while (current != null) {
            result.append(current.data).append(" --> ");
            current = current.next;
        }

        result.append("\b\b\b\b");
        return result.toString();
    }

    public int sum() {
        if (head == null) {
            return -999;
        }
        int sum = 0;
        Node current = head;
        while (current != null) {
            sum += current.data;
            current = current.next;
        }

        return sum;
    }

    public int indexOf(int value) {
        int index = -1;

        if (head == null) {
            System.out.println("Element not found");
            return index;
        }

        Node current = head;
        int count = 0;
        while (current != null) {
            if (current.data == value) {
                index = count;
                break;
            } else {
                count++;
                current = current.next;
            }
        }

        return index;

    }

    public void insertAtBeginning(int value) {
        Node node = new Node(value);
        if (isEmpty()) {
            insert(value);
        } else {
            node.next = head;
            head = node;
        }
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void insertAtIndex(int index, int value) {
        if(isEmpty()) {
            throw new IllegalArgumentException();
        }
        if(index == 0) {
            insertAtBeginning(value);
            return;
        }
        Node node = new Node(value);
        Node current = new Node();
        current = head;
        int count = 0;
        while(count != index && current != null) {
            current = current.next;
            count++;
        }
        node.next = current.next;
        current.next = node;
    }

    public void reverse() {
        if(isEmpty() || head.next == null) {
            return;
        }
        Node prev = null;
        Node current = head;
        Node next = head.next;

        while(next != null) {
            current.next = prev;
            prev = current;
            current = next;
            next = next.next;
        }
        current.next = prev;
        head = current;

    }

    public void deleteFromBeginning() {
        if(isEmpty()) {
            System.err.println("List is Empty!");
            return;
        }
        // if only one element is present in the list
        if(head.next == null) {
            head = null;
            return;
        }

        Node curr = head;
        head = curr.next;
        curr.next = null;
    }

    public void deleteFromEnd() {
        if(isEmpty()) {
            System.err.println("List is Empty!");
            return;
        }
        // if only one element is present in the list
        if(head.next == null) {
            head = null;
            return;
        }
        Node current = head;
        while(current.next.next != null) {
            current = current.next;
        }
        tail = current;
        current.next = null;
    }

    public void removeNthFromEnd(int n) {
        if(isEmpty()) return;

        if(head.next == null ) {
            head = null;
            return;
        }

        int totalNodes = 0;
        Node current = head;
        while(current != null) {
            current = current.next;
            totalNodes++;
        }

        if(totalNodes == n) {
            return;
        }

        int indexFromFront = totalNodes - n + 1;
        Node prev = null;
        current = head;
        while(indexFromFront > 1 && current != null) {
            prev = current;
            current = current.next;
            indexFromFront--;
        }

        if(prev == null) {
            head.next = null;
            head = current;
            return;
        }
        prev.next = current.next;
        current.next = null;
    }

    public void removeNthFromEndFast(int n) {
        if(isEmpty()) return;
        if(head.next == null) {
            head = null;
            return;
        }

        Node fast = head;
        Node current = head;
        Node prev = null;

        while(n > 1 && fast != null) {
            fast = fast.next;
            n--;
        }
        while(fast.next != null) {
            prev = current;
            current = current.next;
            fast = fast.next;
        }

        if(prev == null) {
            head.next = null;
            head = current.next;

        }

        prev.next = current.next;
        current.next = null;
    }

    public void printRec(Node head) {
        if(head == null) {
            System.out.print("\b\b\b\b");
            return;
        }
        System.out.print(head.data + " --> ");
        printRec(head.next);
    }

    public void printRec() {
        printRec(head);
    }

    public Node reverseRec(Node head) {
        if(head == null || head.next == null) return head;

        Node rest = reverseRec(head.next);

        Node next = head.next;
        next.next = head;
        head.next = null;

        return rest;
    }

    public void reverseRec() {
        head = reverseRec(head);
    }
}
