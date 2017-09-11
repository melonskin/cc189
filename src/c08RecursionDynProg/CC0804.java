package c08RecursionDynProg;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by SkinTang on 9/10/17.
 */
public class CC0804 {

    public Set<Set<Integer>> generateAllSubsets(List<Integer> list) {
        if (list.isEmpty()) {
            Set<Set<Integer>> resultSet = new HashSet<>();
            resultSet.add(new HashSet<>());
            return resultSet;
        }
        Integer tempInt = list.remove(0);
        Set<Set<Integer>> resultSet = generateAllSubsets(list);
        Set<Set<Integer>> moreSet = new HashSet<>();
        for (Set<Integer> set : resultSet) {
            Set<Integer> newSet = new HashSet<>();
            newSet.addAll(set);
            newSet.add(tempInt);
            moreSet.add(newSet);
        }
        resultSet.addAll(moreSet);
        return resultSet;
    }

    public Set<Set<Integer>> generateAllSubsetsIter(List<Integer> list) {
        Set<Set<Integer>> resultSet = new HashSet<>();
        int kMax = 1 << list.size();
        for (int k = 0; k < kMax; k++) {
            Set<Integer> oneSet = convertIntToSet(k, list);
            resultSet.add(oneSet);
        }
        return resultSet;
    }

    private Set<Integer> convertIntToSet(int k, List<Integer> list) {
        Set<Integer> oneSet = new HashSet<>();
        int index = 0;
        for (int x = k; x > 0; x >>= 1, index++) {
            if ((x & 1) > 0) {
                oneSet.add(list.get(index));
            }
        }
        return oneSet;
    }

    public static void main(String[] args) {

    }
}
