package c02LinkedList;

/**
 * Created by SkinTang on 7/3/17.
 * Return Kth to Last:
 * Implement an algorithm to find the kth to last element of a singly linked list.
 * Hints:#8, #25, #41, #67, #126
 */
public class CC0202 {
    int findKthToLast(Node head, int k) {
        if (head.next == null) {
            return 0;
        }
        int index = findKthToLast(head.next, k) + 1;
        if (index == k) {
            System.out.println(head.data);
        }
        return index;
    }

    private class Index {
        public int value;
    }
    private Node findKthToLastRecur(Node head, int k) {
        Index idx = new Index();
        return findKthToLastRecur(head, k, idx);
    }

    private Node findKthToLastRecur(Node head, int k, Index idx) {
        if (head == null) {
            return null;
        }
        Node node = findKthToLastRecur(head.next, k, idx);
        idx.value += 1;
        if (idx.value == k) {
            return head;
        } else if (idx.value < k) {
            return null;
        } else {
            return node;
        }
    }

    private Node findKthToLastIter(Node head, int k) {
        Node right = head;
        Node left = head;
        while (k > 1) {
            right = right.next;
            k--;
            if (right == null) {
                return null;
            }
        }
        while (right.next != null) {
            right = right.next;
            left = left.next;
        }
        return left;
    }

    public static void main(String[] args) {
        LinkedListImpl l = new LinkedListImpl(1);
        l.appendToTail(2);
        l.appendToTail(3);
        l.appendToTail(4);
        l.appendToTail(5);
        Node head = l.getHead();

        CC0202 test = new CC0202();
        Node nd1 = test.findKthToLastRecur(head,2);
        System.out.println(nd1.data);
    }

}
