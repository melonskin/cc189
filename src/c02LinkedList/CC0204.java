package c02LinkedList;

/**
 * Created by SkinTang on 7/3/17.
 * Partition: Write code to partition a linked list around a value x,
 * such that all nodes less than x come before all nodes greater than or equal to x.
 * If x is contained within the list, the values of x only need to be after the elements less than x (see below).
 * The partition element x can appear anywhere in the "right partition";
 * it does not need to appear between the left and right partitions.
 *
 * Input: 3 -> 5 -> 8 -> 5 -> 10 -> 2 -> 1[partition=5]
 * Output: 3 -> 1 -> 2 -> 10 -> 5 -> 5 -> 8
 *
 * Hints: #3, #24
 */
public class CC0204 {
    private Node partitionTwoList(Node node, int x) {
        Node beforeNode = null;
        Node afterNode = null;
        Node beforeHead = null;
        Node afterHead = null;
        while (node != null) {
            if (node.data < x) {
                if (beforeNode == null) {
                    beforeNode = node;
                    beforeHead = node;
                } else {
                    beforeNode.next = node;
                    beforeNode = node;
                }
            } else {
                if (afterNode == null) {
                    afterNode = node;
                    afterHead = node;
                } else {
                    afterNode.next = node;
                    afterNode = node;
                }
            }
            node = node.next;
        }
        if (afterNode != null) {
            afterNode.next = null;
        }
        if (beforeNode != null) {
            beforeNode.next = afterHead;
        } else {
            beforeHead = afterHead;
        }
        return beforeHead;
    }

    private Node partition(Node node, int x) {
        Node head = node;
        Node tail = node;

        while (node != null) {
            Node next = node.next;
            if (node.data < x) {
                node.next = head;
                head = node;
            } else {
                tail.next = node;
                tail = node;
            }
            node = next;
        }
        tail.next = null;
        return head;
    }

    public static void main(String[] args) {
        LinkedListImpl l = new LinkedListImpl(3);
        l.appendToTail(5);
        l.appendToTail(8);
        l.appendToTail(5);
        l.appendToTail(10);
        l.appendToTail(2);
        l.appendToTail(1);
        Node head = l.getHead();
        CC0204 test = new CC0204();
        Node node = test.partitionTwoList(head, 5);
        while (node != null) {
            System.out.println(node.data);
            node = node.next;
        }
    }
}
