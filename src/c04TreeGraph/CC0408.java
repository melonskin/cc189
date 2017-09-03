package c04TreeGraph;

import c04TreeGraph.Util.*;
/**
 * Created by SkinTang on 7/14/17.
 *
 * First Common Ancestor:
 *
 * Design an algorithm and write code to find the first common ancestor
 * of two nodes in a binary tree.
 * Avoid storing additional nodes in a data structure.
 * NOTE: This is not necessarily a binary search tree.
 *
 * Hints: #10, 16, 28, 36, 46, 70, 80, 96
 */

public class CC0408 {

    private boolean isAncestor(BTNode up, BTNode down) {
        if (up == down) {
            return true;
        }
        if (up == null) {
            return false;
        }
        return (isAncestor(up.left, down) || isAncestor(up.right,down));
    }

    public BTNode findFirstAncestor(BTNode n1, BTNode n2, BTNode root) {
        BTNode node = root;
        BTNode previousNode = null;
        while (isAncestor(node, n1) && isAncestor(node, n2)) {
            previousNode = node;
            if (isAncestor(node.left, n1) && isAncestor(node.left, n2)) {
                node = node.left;
            } else {
                node = node.right;
            }
        }
        return previousNode;
    }

    class Result {
        public BTNode node;
        public boolean isAncestor;
        Result(BTNode node, boolean isAncestor) {
            this.node = node;
            this.isAncestor = isAncestor;
        }
    }
    public BTNode commonAncestor(BTNode root, BTNode p, BTNode q) {
        Result result = commonAncestorHelper(root, p, q);
        if (result.isAncestor) {
            return result.node;
        }
        return null;
    }
    private Result commonAncestorHelper(BTNode root, BTNode p, BTNode q) {
        if (root == null) {
            return new Result(null, false);
        }
        if (root == p && root == q) {
            return new Result(root, true);
        }
        Result leftResult = commonAncestorHelper(root.left, p, q);
        if (leftResult.isAncestor) {
            return leftResult;
        }
        Result rightResult = commonAncestorHelper(root.right, p, q);
        if (rightResult.isAncestor) {
            return rightResult;
        }
        if (leftResult.node != null && rightResult.node != null) {
            return new Result(root, true);
        } else if (root == p || root == q) {
            boolean isAncestor = leftResult.node != null || rightResult.node != null;
            return new Result(root, isAncestor);
        } else {
            return new Result(leftResult.node != null ? leftResult.node : rightResult.node, false);
        }
    }
}
