package c04TreeGraph;

import c04TreeGraph.Util.*;
/**
 * Created by SkinTang on 7/12/17.
 *
 * Check Balanced:
 * Implement a function to check if a binary tree is balanced.
 * For the purpose of this question,
 * a balanced tree is defined to be a tree such that
 * the height of the two subtree of any node never differ by more than one.
 *
 * Hints: #21, #33, #49, #105, #124
 */
public class CC0404 {
    private static class BalancedData {
        public boolean isBlanced;
        public int height;
    }
    public boolean isBalanced(BTNode<Integer> root) {
        BalancedData result = isBalancedInner(root);
        return result.isBlanced;
    }

    private BalancedData isBalancedInner(BTNode<Integer> node) {
        BalancedData result = new BalancedData();
        if (node == null) {
            result.isBlanced = true;
            result.height = 0;
            return result;
        }
        BalancedData leftData = isBalancedInner(node.left);
        BalancedData rightData = isBalancedInner(node.right);
        if (!leftData.isBlanced || !rightData.isBlanced) {
            result.isBlanced = false;
            return result;
        }
        if (Math.abs(leftData.height - rightData.height) > 1) {
            result.isBlanced = false;
            return result;
        }
        result.isBlanced = true;
        result.height = (leftData.height > rightData.height) ?  leftData.height + 1 : rightData.height + 1;
        return result;
    }
}
