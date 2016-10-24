package LinkedList;

/**
 * Delete a node from given a doubly linked list.
 */
public class DeleteNodeInDoublyLinkedList {
    class Node
    {
        int data;
        Node next;
        Node prev;
        Node(int d)
        {
            data = d;
            next = prev = null;
        }
    }

    Node head = null;

    Node deleteNode(Node head,Node del)
    {
        Node oriHead = head;
        if(head == null)
            return null;

        if(head == del) {
            Node toDel = head;
            head = head.next;
            toDel.next = null;
            head.prev = null;
            return head;
        }

        while (head.next != del) {
            head = head.next;
        }

        Node toDel = head.next;
        head.next = toDel.next;

        if(toDel.next != null) {
            toDel.next.prev = head;
        }
        toDel.next = null;
        toDel.prev = null;
        return oriHead;

    }
}
