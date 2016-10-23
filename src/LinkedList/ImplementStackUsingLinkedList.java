package LinkedList;

/**
 * Implement a Stack using Linked List.
 */
public class ImplementStackUsingLinkedList {

    class StackNode
    {
        int data;
        StackNode next;
    }

    class Stack_using_LinkedList
    {
        StackNode top;
    }

    void push(int a,Stack_using_LinkedList ob)
    {
        StackNode node = new StackNode();
        node.data = a;
        node.next = ob.top;
        ob.top = node;
    }


    int pop(Stack_using_LinkedList ob)
    {
        if(ob.top == null)
            return -1;

        int pop = ob.top.data;
        StackNode toPop = ob.top;
        ob.top = ob.top.next;
        toPop.next = null;

        return pop;
    }
}
