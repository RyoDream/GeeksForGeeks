package LinkedList;

/**
 * Count nodes of linked list
 *
 * Given a singly linked list, find the length of linked list.
 * For example, if given linked list is 1->2->1->2->1->3->1,
 * then output should be 7.
 */
public class CountNodesOfLinkedList {
    class Node {
        int data;
        Node next;
        Node(int d)  { data = d;  next = null; }
    }

    class LinkedList {
        Node head;
    }

    public int getCount(LinkedList list) {
        if(list == null)
            return 0;
        int count = 1;
        Node head = list.head;
        while(head.next != null) {
            head = head.next;
            count++;
        }
        return count;
    }
}
