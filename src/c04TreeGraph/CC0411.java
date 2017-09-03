package c04TreeGraph;

import java.util.Random;
/**
 * Created by SkinTang on 7/14/17.
 *
 * Random Node:
 *
 * You are implementing a binary tree class from scratch which,
 * in addition to insert, find, and delete, has a method getRandomNode()
 * which returns a random node from the tree.
 * All nodes should be equally likely to be chosen.
 * Design and implement an algorithm for getRandomNode,
 * and explain how you would implement the rest of the methods.
 *
 * Hints: #42, 54, 62, 75, 89, 99, 112, 119
 */
public class CC0411 {
    private static class BTNode3<T> {
        public T data;
        public BTNode3<T> parent = null;
        public BTNode3<T> left = null;
        public BTNode3<T> right = null;
        public int nodeNum;
        public BTNode3(T data) {
            this.data = data;
            nodeNum = 1;
        }
    }
    private class MyRandomBTree<T> {
        private BTNode3<T> root;
        public BTNode3<T> getRandomNode() {
            return getRandomNode(root);
        }
        private BTNode3<T> getRandomNode(BTNode3<T> node) {
            // if (node == null) {
            //     return null;
            // }
            int nodeNumThis = node.nodeNum;
            int nodeNumLeft = (node.left == null) ? 0 : node.left.nodeNum;
            int nodeNumRight = (node.right == null) ? 0 : node.right.nodeNum;
            Random random = new Random();
            if (random.nextInt(nodeNumThis) == 0) {
                return node;
            }
            if (random.nextInt(nodeNumRight + nodeNumLeft) < nodeNumLeft) {
                return getRandomNode(node.left);
            } else {
                return getRandomNode(node.right);
            }
        }
        public boolean insert(BTNode3<T> node) {
            // update all nodeNum, up through parent to root
            return false;
        }

        public boolean delete() {
            // update all nodeNum, up through parent to root
            return false;
        }
    }
}
