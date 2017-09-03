package c04TreeGraph;

import c04TreeGraph.Util.*;
import java.util.*;
/**
 * Created by SkinTang on 7/14/17.
 *
 * Check Subtree:
 *
 * T1 and T2 are two very large binary trees,
 * with T1 much larger than T2.
 * Create an algorithm to determine if T2 is a subtree of T1.
 *
 * A tree T2 is a subtree of T1 if there exists a node n in T1
 * such that the subtree of n is identical to T2.
 * That is, if you cut off the tree at node n,
 * the two trees would be identical.
 *
 * Hints: #4, 11, 18, 31, 37
 * Pre-order traversal with null node included
 */
public class CC0410 {
    public boolean isSubtree(BTNode n2, BTNode n1) {
        Queue<BTNode> queue = new LinkedList<>();
        queue.add(n1);
        while (!queue.isEmpty()) {
            BTNode node = queue.remove();
            if (isSameTree(node,n2)) {
                return true;
            }
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
        return false;
    }
    public boolean isSameTree(BTNode n2, BTNode n1) {
        if (n1 == null && n2 == null) {
            return true;
        }
        if (n1 == null || n2 == null) {
            return false;
        }
        if (n1.data != n2.data) {
            return false;
        }
        return (isSameTree(n1.left, n2.left) && isSameTree(n1.right, n2.right));
    }

    public boolean containsTree(BTNode<Integer> n2, BTNode<Integer> n1) {
        StringBuilder string1 = new StringBuilder();
        StringBuilder string2 = new StringBuilder();

        getTraversalString(n1, string1);
        getTraversalString(n2, string2);

        return (string1.indexOf(string2.toString()) != -1);
    }

    void getTraversalString(BTNode<Integer> node, StringBuilder sb) {
        if (node == null) {
            sb.append("_").append("x");
        }
        sb.append("_").append(node.data);
        getTraversalString(node.left, sb);
        getTraversalString(node.right, sb);
    }
}
