package c04TreeGraph;

import c04TreeGraph.Util.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by SkinTang on 7/14/17.
 *
 * BST Sequences:
 *
 * A binary search tree was created by traversing through an array from left to right
 * and inserting each element.
 * Given a binary search tree with distinct elements,
 * print all possible arrays that could have led to this tree.
 *
 * EXAMPLE:
 *
 * Input: 1 <- 2 -> 3
 * Output: {2, 1, 3}, {2, 3, 1}
 *
 * Hints: #39, 48, 66, 82
 */
public class CC0409 {
    public ArrayList<LinkedList<Integer>> treeArray(BTNode<Integer> node) {
        ArrayList<LinkedList<Integer>> result = new ArrayList<>();
        Queue<BTNode<Integer>> queue = new LinkedList<>();
        LinkedList<Integer> tempList = new LinkedList<>();
        queue.add(node);
        result.add(new LinkedList<>());
        int num = 1;
        int numNext = 0;
        while (!queue.isEmpty()) {
            BTNode<Integer> tmp = queue.remove();
            tempList.addLast(tmp.data);
            num--;
            if (tmp.left != null) {
                numNext++;
                queue.add(tmp.left);
            }
            if (tmp.right != null) {
                numNext++;
                queue.add(tmp.right);
            }
            if (num == 0) {
                ArrayList<LinkedList<Integer>> permutationResult = permutation(tempList);
                ArrayList<LinkedList<Integer>> tempResultList = new ArrayList<>();
                for (int i = 0; i < result.size(); i++) {
                    for (int j = 0; j < permutationResult.size(); j++) {
                        LinkedList<Integer> prefix = result.get(i);
                        LinkedList<Integer> last = permutationResult.get(j);
                        LinkedList<Integer> all = new LinkedList<>();
                        all.addAll(prefix);
                        all.addAll(last);
                        tempResultList.add(all);
                    }
                }
                result = tempResultList;
                num = numNext;
                numNext = 0;
                tempList = new LinkedList<>();
            }
        }
        return result;
    }

    private ArrayList<LinkedList<Integer>> permutation(LinkedList<Integer> list) {
        ArrayList<LinkedList<Integer>> result = new ArrayList<>();
        if (list.size() == 0) {
            result.add(new LinkedList<Integer>());
            return result;
        }
        LinkedList<Integer> nextList = new LinkedList<>();
        nextList.addAll(list);
        Integer head = nextList.removeFirst();
        ArrayList<LinkedList<Integer>> nextResult = permutation(nextList);
        for (int i = 0; i <= nextList.size(); i++) {
            for (LinkedList<Integer> oneNextList : nextResult) {
                LinkedList<Integer> tempList = new LinkedList<>();
                LinkedList<Integer> tempResult = new LinkedList<>();
                tempList.addAll(oneNextList);
                int n = 0;
                while (!tempList.isEmpty()) {
                    if (n == i) {
                        tempResult.add(head);
                    } else {
                        tempResult.add(tempList.remove());
                    }
                    n++;
                }
                result.add(tempResult);
            }
        }
        return result;
    }

    public ArrayList<LinkedList<Integer>> allSeq(BTNode<Integer> node) {
        ArrayList<LinkedList<Integer>> result = new ArrayList<>();

        if (node == null) {
            result.add(new LinkedList<>());
            return result;
        }

        ArrayList<LinkedList<Integer>> leftResult = allSeq(node.left);
        ArrayList<LinkedList<Integer>> rightResult = allSeq(node.right);

        LinkedList<Integer> prefix = new LinkedList<>();
        prefix.add(node.data);

        for (LinkedList<Integer> left : leftResult) {
            for (LinkedList<Integer> right : rightResult) {
                ArrayList<LinkedList<Integer>> weavedLists = new ArrayList<>();
                weaveList(weavedLists, left, right, prefix);
                result.addAll(weavedLists);
            }
        }
        return result;
    }

    private void weaveList(ArrayList<LinkedList<Integer>> weavedLists, LinkedList<Integer> left, LinkedList<Integer> right, LinkedList<Integer> prefix) {
        if (left.size() == 0 || right.size() == 0) {
            LinkedList<Integer> result = new LinkedList<>();
            result.addAll(prefix);
            result.addAll(left);
            result.addAll(right);
            weavedLists.add(result);
            return;
        }

        Integer head = left.removeFirst();
        prefix.addLast(head);
        weaveList(weavedLists, left, right, prefix);
        left.addFirst(head);
        prefix.removeLast();

        head = right.removeFirst();
        prefix.addLast(head);
        weaveList(weavedLists, left, right, prefix);
        right.addFirst(head);
        prefix.removeLast();
    }
}

