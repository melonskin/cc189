package c02LinkedList;

/**
 * Created by SkinTang on 7/3/17.
 * Delete Middle Node:
 * Implement an algorithm to delete a node in the middle
 * (i.e., any node but the first and last node, not necessarily the exact middle) of a singly linked list,
 * given only access to that node.
 * Input: the node c from the linked list a->b->c->d->e->f
 * Result: nothing is returned, but the new linked list looks like a->b->d->e->f
 * Hints:#72
 */
public class CC0203 {
    private boolean deleteNode(Node n) {
        if (n == null || n.next == null) {
            return false;
        }
        n.data = n.next.data;
        n.next = n.next.next;
        return true;
    }
}
