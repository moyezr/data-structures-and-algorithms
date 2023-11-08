package LinkedList;

public class TestingSinglyLinkedList {
    public static void main(String args[]) {
        SinglyLinkedList myLinkedList = new SinglyLinkedList();
        myLinkedList.insert(10);
        myLinkedList.insert(20);
        myLinkedList.insert(30);
        myLinkedList.insert(40);
        myLinkedList.insert(50);
//        System.out.println(myLinkedList.toString());
        System.out.println(myLinkedList);
        myLinkedList.reverseRec();
        System.out.println(myLinkedList);




    }
}
