package LinkedList;

/**
 * Insert a node in Doubly linked list
 */
public class InsertANodeInDoublyLinkedList {
    class Node
    {
        int data;
        Node next;
        Node prev;
    }

    void addNode(Node head_ref, int pos, int data)
    {
        Node newNode = new Node();
        newNode.data = data;

        if(head_ref == null)
            head_ref = newNode;
        else {
            while (head_ref != null && pos-- > 0) {
                head_ref = head_ref.next;
            }

            if(head_ref.next == null) {
                head_ref.next = newNode;
                newNode.prev = head_ref;
            }
            else {
                newNode.next = head_ref.next;
                newNode.prev = head_ref;
                head_ref.next.prev = newNode;
                head_ref.next = newNode;
            }
        }
    }
}
