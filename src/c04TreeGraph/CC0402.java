package c04TreeGraph;

/**
 * Created by SkinTang on 7/12/17.
 * Minimal Tree:
 * Given a sorted (increasing order) array with unique integer elements,
 * write an algorithm to create a binary search tree with minimal height
 *
 * Hints: #19, #73, #116
 *
 */
public class CC0402 {
    private static class TreeNode<T> {
        public T data;
        public TreeNode<T> left;
        public TreeNode<T> right;
        TreeNode (T data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    public TreeNode<Integer> generateBST(int[] arr) {
        return generateBST(arr, 0, arr.length-1);
    }

    private TreeNode<Integer> generateBST(int[] arr, int lo, int hi) {
        if (lo > hi) {
            return null;
        }

        int mid = (lo + hi) / 2 + (lo + hi) % 2;
        TreeNode<Integer> father = new TreeNode<>(arr[mid]);
        father.left = generateBST(arr, lo, mid-1);
        father.right = generateBST(arr, mid+1, hi);
        return father;
    }


    public void inOrder(TreeNode<Integer> root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        visit(root);
        inOrder(root.right);
    }

    private void visit(TreeNode<Integer> node) {
            System.out.println(node.data);
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8};
        CC0402 test = new CC0402();
        TreeNode<Integer> root = test.generateBST(arr);
        test.inOrder(root);
    }

}
