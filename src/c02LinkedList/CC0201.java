package c02LinkedList;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by SkinTang on 6/18/17.
 * Write code to remove duplicates from an unsorted linked list.
 * How would you solve this problem if a temporary buffer is not allowed?
 * Solution:
 * 1, use a set or array to remember unique element in the linked list
 * 2, if temporary buffer is not allowed, use two pointers,
 * one search ahead of the other, O(N^2) in time
 */

public class CC0201 {
    private void rmDuplicate(LinkedListImpl l) {
        Node current = l.getHead();
        Set<Integer>  uniqueSet = new HashSet<>();
        uniqueSet.add(current.data);
        while (current.next != null) {
            if (uniqueSet.contains(current.next.data)) {
                current.next = current.next.next;
            } else {
                uniqueSet.add(current.next.data);
                current = current.next;
            }

        }
    }

    private void rmDuplicate2(LinkedListImpl l) {
        Node current = l.getHead();
        Node previous = null;
        Set<Integer>  uniqueSet = new HashSet<>();
        while (current != null) {
            if (uniqueSet.contains(current.data)) {
                previous.next = current.next;
            } else {
                uniqueSet.add(current.data);
                previous = current;
            }
            current = current.next;
        }
    }

    private void rmDuplicateNoBuffer(LinkedListImpl l) {
        Node head = l.getHead();
        while (head != null) {
            Node previous = head;
            Node current = head.next;
            while (current != null) {
                if (current.data == head.data) {
                    previous.next = current.next;
                } else {
                    previous = current;
                }
                current = current.next;
            }
            head = head.next;
        }
    }

    public static void main(String[] args) {
        LinkedListImpl l = new LinkedListImpl(1);
        l.appendToTail(1);
        l.appendToTail(2);
        l.appendToTail(3);
        l.appendToTail(2);
        l.appendToTail(2);
        l.appendToTail(2);
        l.appendToTail(4);
        l.appendToTail(4);
        Node head = l.getHead();
        while (head != null) {
            System.out.println(head.data);
            head = head.next;
        }
        System.out.println("----------");
        CC0201 test = new CC0201();
        test.rmDuplicateNoBuffer(l);
        head = l.getHead();
        while (head != null) {
            System.out.println(head.data);
            head = head.next;
        }

    }
}
