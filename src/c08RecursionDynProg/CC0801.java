package c08RecursionDynProg;

/*
 * Triple Step,
 * Hints: 152, 178, 217, 237, 262, 359
 */
public class CC0801 {
    public int numWaysStepDPWrapper(int numStep) {
        int[] memo = new int[numStep + 1];
        memo[0] = 1;
        return numWaysStepDP(numStep, memo);
    }
    public int numWaysStepDP(int numStep, int[] memo) {
        if (numStep < 0) {
            return 0;
        }
        if (memo[numStep] != 0) {
            return memo[numStep];
        }
        memo[numStep] = numWaysStepDP(numStep - 1, memo) +
                numWaysStepDP(numStep - 2, memo) +
                numWaysStepDP(numStep - 3, memo);
        return memo[numStep];
    }

    public static void main(String[] args) {
        CC0801 test = new CC0801();
        System.out.println(test.numWaysStepDPWrapper(4));
    }
}
