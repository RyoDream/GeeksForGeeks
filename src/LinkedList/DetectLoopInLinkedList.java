package LinkedList;

/**
 * Detect Loop in linked list
 *
 * Given a linked list, check if the the linked list has a loop.
 * Linked list can contain self loop.
 */
public class DetectLoopInLinkedList {
    class Node {
        int data;
        Node next;
        Node(int d) {data = d; next = null; }
    }

    int detectLoop(Node head) {
        Node walker = head;
        Node runner = head;

        while (runner != null && runner.next != null) {
            runner = runner.next.next;
            walker = walker.next;
            if(walker == runner)
                return 1;
        }

        return 0;
    }
}
