package c08RecursionDynProg;

/**
 * Created by SkinTang on 6/20/17.
 */
public class Fibonacci {
    private int recursiveFibonacci(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        return recursiveFibonacci(n - 1) + recursiveFibonacci(n - 2);
    }

    long dpMemoFibonacci(int n) {
        return dpMemoFibonacci(n, new long[n+1]);
    }
    long dpMemoFibonacci(int n, long[] memo) {
        if (n == 0 || n == 1) return n;
        if (memo[n] == 0) memo[n] = memo[n-1] + memo[n-2];
        return memo[n];
    }

    private int dpBotUpFinonacci(int n) {
        int a = 0;
        int b = 1;
        n -= 1;
        while (n-- > 0) {
            int c = a + b;
            a = b;
            b = c;
        }
        return b;
    }

    public static void main(String[] args) {
        Fibonacci tsj = new Fibonacci();
//        System.out.print(tsj.recursiveFibonacci(30));
        System.out.println(tsj.dpMemoFibonacci(4));
        System.out.println(tsj.dpBotUpFinonacci(4));

    }
}
