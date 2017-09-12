package c08RecursionDynProg;

import java.util.HashMap;
import java.util.Map;

/*
 * Boolean evaluation
 */
public class CC0814 {
    public int numWaysEvalWrapper(String s, boolean r) {
        Map<String, Integer> memoMap = new HashMap<>();
        return numWaysEval(s, r, memoMap);
    }
    public int numWaysEval(String s, boolean r, Map<String, Integer> memoMap) {
        if (s.length() == 0) {
            return 0;
        }
        if (memoMap.containsKey(s + r)) {
            return memoMap.get(s + r);
        }
        if (s.length() == 1) {
            return (s.equals("1") == r ? 1 : 0);
        }
        int count = 0;
        for (int i = 1; i < s.length(); i += 2) {
            String left = s.substring(0, i);
            String right = s.substring(i + 1);
            int leftTrue = numWaysEval(left, true, memoMap);
            int leftFalse = numWaysEval(left, false, memoMap);
            int rightTrue = numWaysEval(right, true, memoMap);
            int rightFalse = numWaysEval(right, false, memoMap);
            int totalTrue = 0;
            int total = (leftTrue + leftFalse) * (rightTrue + rightFalse);
            if (s.charAt(i) == '&') {
                totalTrue = leftTrue * rightTrue;
            } else if (s.charAt(i) == '|') {
                totalTrue = leftFalse * rightTrue + leftTrue * rightTrue + leftTrue * rightFalse;
            } else if (s.charAt(i) == '^') {
                totalTrue = leftFalse * rightTrue + leftTrue * rightFalse;
            }
            int result = (r) ? totalTrue : total - totalTrue;
            count += result;
        }
        memoMap.put(s + r, count);
        return count;
    }
}
