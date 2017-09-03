package c02LinkedList;

import java.util.Stack;

/**
 * Created by SkinTang on 7/5/17.
 * Palindrome: Implement a function to check if a linked list is a palindrome.
 *
 * Hints:#5, #13, #29, #61, #101
 */
public class CC0206 {
    private boolean isPalindrome(Node head) {
        Node node = head;
        Node newHead = null;
        while (node != null) {
            newHead = insertAtHead(newHead, new Node(node.data));
            node = node.next;
        }
        node = head;

        while (node != null && newHead != null) {
            if (node.data != newHead.data) {
                return false;
            }
            node = node.next;
            newHead = newHead.next;
        }
        return true;
    }

    private Node insertAtHead(Node head, Node newHead) {
        newHead.next = head;
        return newHead;
    }

    private class Result {
        public boolean result;
        public Node node;
        Result(boolean result, Node node) {
            this.result = result;
            this.node = node;
        }
    }

    private boolean isPalindromeRecur(Node head) {
        int len = 0;
        Node node = head;
        while (node != null) {
            len++;
            node = node.next;
        }
        return isPalindromeRecur(head, len).result;
    }

    private Result isPalindromeRecur(Node head, int len) {
        if (len <= 0) {
            return new Result(true, head);
        }
        if (len == 1) {
            return new Result(true, head.next);
        }
        Result res = isPalindromeRecur(head.next, len-2);

        if (!res.result) {
            return res;
        }

        return new Result(head.data == res.node.data, res.node.next);
    }

    public static void main(String[] args) {
        LinkedListImpl l1 = new LinkedListImpl(1);
        l1.appendToTail(2);
        l1.appendToTail(3);
        l1.appendToTail(3);
        l1.appendToTail(2);
        l1.appendToTail(4);

        CC0206 test = new CC0206();
        System.out.println(test.isPalindrome(l1.getHead()));
        System.out.println(test.isPalindromeRecur(l1.getHead()));
    }
}
