package c02LinkedList;

/**
 * Created by SkinTang on 6/15/17.
 */
public class Node {
    public int data;
    public Node next = null;

    Node(int data) {
        this.data = data;
    }
    public void appendToTail(int d) {
        Node lastNode= this;
        while (lastNode.next != null) {
            lastNode = lastNode.next;
        }
        lastNode.next = new Node(d);
    }
}
