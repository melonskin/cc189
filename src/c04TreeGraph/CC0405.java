package c04TreeGraph;

import c04TreeGraph.Util.BTNode;
/**
 * Created by SkinTang on 7/12/17.
 *
 * Validate BST:
 * Implement a function to check if a binary tree is a binary search tree
 *
 * Hints: #35, #57, #86, #113, #128
 */
public class CC0405 {
    private class Result {
        public boolean isBST;
        public int min;
        public int max;
    }
    public boolean isBST(BTNode<Integer> root) {
        Result result = isBSTInner(root);
        return result.isBST;
    }

    private Result isBSTInner(BTNode<Integer> node) {
        Result thisResult = new Result();
        if (node == null) {
            thisResult.isBST = true;
            thisResult.min = Integer.MIN_VALUE;
            thisResult.max = Integer.MIN_VALUE;
        }
        
        Result leftResult = isBSTInner(node.left);
        Result rightResult = isBSTInner(node.right);
        if (!leftResult.isBST || !rightResult.isBST) {
            thisResult.isBST = false;
            return thisResult;
        }
        if ((leftResult.max != Integer.MIN_VALUE && leftResult.max > node.data) ||
            (rightResult.min != Integer.MIN_VALUE && rightResult.min < node.data)) {
            thisResult.isBST = false;
            return thisResult;
        }
        thisResult.isBST = true;
        thisResult.min = (leftResult.min == Integer.MIN_VALUE) ? node.data : leftResult.min;
        thisResult.max = (rightResult.max == Integer.MIN_VALUE) ? node.data : rightResult.max;
        return thisResult;
    }
}
