package Queues;

public class TestingQueueUsingArrays {

    public static void main(String args[]) {
        QueueUsingArrays  myQueue = new QueueUsingArrays(5);

        myQueue.enqueue(1);
        myQueue.enqueue(2);
        myQueue.enqueue(3);
        myQueue.enqueue(4);
        myQueue.enqueue(5);

        myQueue.dequeue();
        myQueue.dequeue();

        myQueue.enqueue(6);
        myQueue.enqueue(7);
        myQueue.dequeue();
        myQueue.dequeue();
        myQueue.enqueue(8);
        myQueue.enqueue(9);


        System.out.println(myQueue);
    }

}
