package LinkedList;

import java.util.HashSet;
import java.util.Set;

/**
 * Circular Linked List
 *
 * Given a singly linked list, find if the linked list is circular or not.
 * A linked list is called circular if it not NULL terminated
 * and all nodes are connected in the form of a cycle.
 *
 * An empty linked list is considered as circular.
 *
 * Note  that this problem is different from cycle detection problem,
 * here all nodes have to be part of cycle.
 */
public class CircularLinkedList {

    class Node {
        int data;
        Node next;
        Node(int d) {
            data = d;
            next = null;
        }
    }

    boolean isCircular(Node head) {
        if(head == null)
            return true;

        Node walker = head;
        Node runner = head;

        while (runner != null && runner.next != null) {
            runner = runner.next.next;
            walker = walker.next;
            if(walker == runner)
                return true;
        }

        return false;
    }
}

