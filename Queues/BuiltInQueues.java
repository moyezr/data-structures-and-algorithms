package Queues;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
public class BuiltInQueues {

    public static void main(String args[]) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);

        System.out.println(queue);
        System.out.println(queue.remove());
        System.out.println(queue);

    }
}
