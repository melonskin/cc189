package c02LinkedList;

/**
 * Created by SkinTang on 6/15/17.
 */
public class LinkedListImpl {

    private Node head;

    LinkedListImpl(int d) {
        this.head = new Node(d);
    }

    public Node getHead() { return head; }

    public void appendToTail(int d) {
        head.appendToTail(d);
    }

    public int rmNode(int d) {
        Node n = head;
        if (n.data == d) {
            head = n.next;
            return 1;
        }
        while (n.next != null) {
            if (n.next.data == d) {
                n.next = n.next.next;
                return 2;
            }
            n = n.next;
        }
        return -1;
    }

    public void print() {
        Node n = head;
        while(n != null) {
            System.out.println(n.data);
            n = n.next;
        }
    }

    public static void main(String[] args) {
        LinkedListImpl test = new LinkedListImpl(1);
        test.appendToTail(2);
        test.appendToTail(3);
        test.appendToTail(4);
        test.print();
        test.rmNode(1);
        test.print();
    }
}
