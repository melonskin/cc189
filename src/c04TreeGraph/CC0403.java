package c04TreeGraph;

import java.util.*;

import c04TreeGraph.Util.BTNode;

/**
 * Created by SkinTang on 7/12/17.
 *
 * List of Depths:
 * Given a binary tree, design an algorithm
 * which creates a linked list of all the nodes at each depth
 * (e.g., if you have a tree with depth D, you'll have D liked lists).
 *
 * Hints: #107, #123, #135
 */
public class CC0403 {

    public List<LinkedList<BTNode<Integer>>> nodesAtEachDepth(BTNode<Integer> root) {
        List<LinkedList<BTNode<Integer>>> result = new ArrayList<>();
        Queue<BTNode<Integer>> queue = new LinkedList<>();
        int num = 1;
        int nextNum = 0;
        queue.add(root);
        LinkedList<BTNode<Integer>> oneList = new LinkedList<>();
        while (!queue.isEmpty()) {
            BTNode<Integer> item = queue.remove();
            oneList.addLast(item);
            num--;
            if (item.left != null) {
                nextNum++;
                queue.add(item.left);
            }
            if (item.right != null) {
                nextNum++;
                queue.add(item.right);
            }
            if (num == 0) {
                num = nextNum;
                nextNum = 0;
                result.add(oneList);
                oneList = new LinkedList<>();
            }
        }
        return result;
    }

    public List<LinkedList<BTNode<Integer>>> nodesAtEachDepthDFS(BTNode<Integer> root) {
        Map<Integer, LinkedList<BTNode<Integer>>> map = new HashMap<>();
        List<LinkedList<BTNode<Integer>>> result = new ArrayList<>();
        dfs(root, map, 0);
        for (int i = 0; i < map.size(); i++){
            result.add(map.get(i));
        }
        return result;
    }

    private void dfs(BTNode<Integer> node, Map<Integer, LinkedList<BTNode<Integer>>> map, int depth) {
        if (node == null) {
            return;
        }
        if (!map.containsKey(depth)) {
            map.put(depth, new LinkedList<>());
        }
        LinkedList<BTNode<Integer>> list = map.get(depth);
        list.addLast(node);
        map.put(depth, list);
        dfs(node.left, map, depth+1);
        dfs(node.right, map, depth+1);
    }

    public List<List<BTNode>> nodeListAtEachDepthBFS(BTNode root) {
        List<List<BTNode>> result = new ArrayList<>();
        List<BTNode> current = new LinkedList<>();
        current.add(root);
        while (current.size() != 0) {
            result.add(current);
            List<BTNode> parent = current;
            current = new LinkedList<>();
            for (BTNode parentNode : parent) {
                if (parentNode.left != null) {
                    current.add(parentNode.left);
                }
                if (parentNode.right != null) {
                    current.add(parentNode.right);
                }
            }
        }
        return result;
    }
}
