package c04TreeGraph;

import c04TreeGraph.Util.*;
import java.util.*;
/**
 * Created by SkinTang on 7/14/17.
 *
 * Paths with Sum:
 *
 * You are given a binary tree which each node contains an integer value
 * (which might be positive or negative).
 * Design an algorithm to count the number of paths
 * that sum to a given value.
 * The path does not need to start or end at the root or a leaf,
 * but it must go downwards (travelling only from parent nodes to child nodes).
 *
 * Hints: #6, 14, 52, 68, 77, 87, 94, 103, 108, 115
 */
public class CC0412 {
    public int countPaths(BTNode<Integer> root, int sumValue) {
        List<Integer> list = new ArrayList<>();
        list.add(0);
        return countPaths(root, list, sumValue);
    }

    public int countPaths(BTNode<Integer> node, List<Integer> list, int sumValue) {
        if (node == null) {
            int count = 0;
            Set<Integer> set = new HashSet<>();
            for (Integer item : list) {
                if (set.contains(item - sumValue)) {
                    count++;
                }
                set.add(item);
            }
            return count;
        }
        List<Integer> list2 = new ArrayList<>();
        list2.addAll(list);
        list2.add(list2.get(list2.size() - 1) + node.data);
        return countPaths(node.left, list2, sumValue) + countPaths(node.right, list2, sumValue);
    }

    public int countPaths2(BTNode<Integer> root, int sumValue) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        return countPaths2(root, 0, map, sumValue);
    }

    private int countPaths2(BTNode<Integer> node, int runningSum, Map<Integer, Integer> sumCountMap, int sumValue) {
        if (node == null) {
            return 0;
        }
        runningSum += node.data;
        int sum = runningSum - sumValue;
        int pathCount = sumCountMap.getOrDefault(sum, 0);
        changeCountMap(sumCountMap, runningSum, 1);
        pathCount += countPaths2(node.left, runningSum, sumCountMap, sumValue);
        pathCount += countPaths2(node.right, runningSum, sumCountMap, sumValue);
        changeCountMap(sumCountMap, runningSum, -1);
        return pathCount;
    }
    private void changeCountMap(Map<Integer, Integer> map, int runningSum, int value) {
        int newCount = map.getOrDefault(runningSum, 0) + value;
        if (newCount == 0) {
            map.remove(runningSum);
        } else {
            map.put(runningSum, newCount);
        }
    }
}
