package c08RecursionDynProg;

import java.util.Arrays;

/*
 * Coins
 * count ways to get n cents with 1, 5, 10, 25 cents
 */
public class CC0811 {
    public int makeChanges(int n) {
        int[] valueArr = {25, 10, 5, 1};
        int[][] memo = new int[n + 1][valueArr.length];
        Arrays.fill(memo, -1);
        return makeChanges(n, valueArr, 0, memo);
    }

    private int makeChanges(int n, int[] valueArr, int index, int[][] memo) {
        if (memo[n][index] != -1) {
            return memo[n][index];
        }
        if (index >= valueArr.length - 1) return 1;
        int value = valueArr[index];
        int ways = 0;
        for (int i = 0; i * value <= n; i++) {
            int remainN = n - i * value;
            ways += makeChanges(remainN, valueArr, index + 1, memo);
        }
        memo[n][index] = ways;
        return ways;
    }
}
