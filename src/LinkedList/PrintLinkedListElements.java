package LinkedList;

/**
 * Print Linked List elements
 *
 * You are given the pointer to the head node of a linked list.
 * You have to print all of its elements in order in a single line.
 */
public class PrintLinkedListElements {
    class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    void printList(Node head) {
        while(head != null) {
            System.out.println(head.data);
            head = head.next;
        }
    }
}
