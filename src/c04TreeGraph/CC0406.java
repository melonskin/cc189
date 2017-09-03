package c04TreeGraph;

/**
 * Created by SkinTang on 7/12/17.
 *
 * Successor:
 * Write an algorithm to find the "next" node
 * (i.e., in-order successor) of a given node in a binary search tree.
 * You may assume that each node has a link to its parent.
 *
 * Hints: #79, #91
 */
public class CC0406<T> {
    private static class BTNode2<T> {
        public T data;
        public BTNode2<T> left;
        public BTNode2<T> right;
        public BTNode2<T> parent;
    }
    public BTNode2<T> successor(BTNode2<T> node) {
        if (node.right != null) {
            BTNode2<T> next = node.right;
            while (next.left != null) {
                next = next.left;
            }
            return next;
        }
        BTNode2<T> node2 = node;
        BTNode2<T> parent = node2.parent;
        while (parent != null && parent.right == node2) {
            node2 = parent;
            parent = parent.parent;
        }
        return parent;
    }
}
