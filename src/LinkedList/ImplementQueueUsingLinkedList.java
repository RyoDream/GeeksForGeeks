package LinkedList;

/**
 * Implement a Queue using Linked List.
 */
public class ImplementQueueUsingLinkedList {
    class QueueNode
    {
        int data;
        QueueNode next;
    }

    static class Queue_using_LinkedList
    {
        QueueNode front;
        QueueNode rear;
    }

    void push(int a,Queue_using_LinkedList ob)
    {
        QueueNode newNode = new QueueNode();
        newNode.data = a;

        if(ob.front == null) {
            ob.front = newNode;

        }
        else {
            ob.rear.next = newNode;
        }
        ob.rear = newNode;
    }

    int pop(Queue_using_LinkedList ob) {
        if(ob.front == null)
            return -1;

        int pop = ob.front.data;
        if(ob.front == ob.rear) {
            ob.front = ob.rear = null;
        }
        else {
            ob.front = ob.front.next;
        }

        return pop;
    }

    public static void main(String[] args) {

        ImplementQueueUsingLinkedList queue = new ImplementQueueUsingLinkedList();
        Queue_using_LinkedList list = new Queue_using_LinkedList();

        String operator = "1 78 2 2 2 1 93 2 2 1 28 1 60 2 1 41 1 73 1 12 1 68 2 1 31 1 24 2 2 2 1 23 1 70 2 2 1 12 1 30 2 2 2 1 38 1 25 2 1 14 1 92 1 57 2 1 71 1 82 2 2 1 28 1 6 1 30 2 2 1 96 1 46 1 68 1 65 2 1 88 1 77 1 89 1 4 2 1 100 1 61 1 69 2 1 27 1 95 2 2 1 35 1 68 2 2 1 18 1 53 1 2 1 87 2 2 2 1 20 1 30 2 2 2 2 2 2 2 2 ";
        String[] operators = operator.split(" ");
        boolean insert = false;
        for(String op : operators) {
            if(insert) {
                queue.push(Integer.parseInt(op), list);
                insert = false;
            }
            else if(op.equals("2")) {
                System.out.print(queue.pop(list)+" ");
            }
            else {
                insert = true;
            }
        }
    }
}
