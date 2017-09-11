package c08RecursionDynProg;

import java.util.Arrays;

/**
 * Created by SkinTang on 9/10/17.
 * Recursive Multiply
 */
public class CC0805 {
    public int multiply(int a, int b) {
        int smaller = (a < b) ? a : b;
        int bigger = (a < b) ? b : a;
        int[] memo = new int[smaller + 1];
        Arrays.fill(memo, -1);
        return multiplyHelper(smaller, bigger, memo);
    }
    private int multiplyHelper(int smaller, int bigger, int[] memo) {
        if (memo[smaller] != -1) {
            return memo[smaller];
        }
        if (smaller == 0) {
            memo[smaller] = 0;
            return memo[smaller];
        }
        if (smaller == 1) {
            memo[smaller] = bigger;
            return memo[smaller];
        }
        int addition = 0;
        if (smaller % 2 == 1) {
            addition = bigger;
        }
        int smallerHalf = smaller >> 1;
        int halfResult = multiplyHelper(smallerHalf, bigger, memo);
        return halfResult + halfResult + addition;
    }

    public static void main(String[] args) {
        CC0805 test = new CC0805();
        System.out.println(test.multiply(5,9));
    }
}
