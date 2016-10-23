package LinkedList;

/**
 * Finding middle element in a linked list
 *
 * Given a singly linked list, find middle  of the linked list.
 * For example, if given linked list is 1->2->3->4->5 then output should be 3.
 *
 * If there are even nodes, then there would be two middle nodes,
 * we need to print second middle element.
 *
 * For example, if given linked list is 1->2->3->4->5->6 then output should be 4.
 */
public class FindingMiddleElementInALinkedList {
    class Node {
        int data;
        Node next;
        Node(int d)  { data = d;  next = null; }
    }

    class LinkedList {
        Node head;  // head of list
    }

    int getMiddle(Node head) {
        Node walker = head;
        Node runner = head;

        while (runner != null && runner.next != null) {
            walker = walker.next;
            runner = runner.next.next;
        }

        return walker.data;
    }
}
