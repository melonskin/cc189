package c06MathPuzzle;

/**
 * Created by SkinTang on 6/20/17.
 * Find all primes less than a number
 */
public class FindPrime {
    boolean[] sieveOfEratosthenes(int max) {
        boolean[] flags = new boolean[max+1];
        int prime = 2;
        init(flags);
        while (prime <= Math.sqrt(max)) {
            crossOff(flags, prime);
            prime = returnNextPrime(flags, prime);
        }
        return flags;
    }
    void crossOff(boolean[] flags, int prime) {
        for (int i = prime * prime; i < flags.length; i += prime) {
            flags[i] = false;
        }
    }

    int returnNextPrime(boolean[] flags, int prime) {
        int n = prime + 1;
        while (n < flags.length && !flags[n]) {
            n++;
        }
        return n;
    }

    void init(boolean[] flags) {
        for (int i = 0; i < flags.length; i++)
            flags[i] = true;
    }

    public static void main(String[] args) {
        int max = 289;
        FindPrime tsj = new FindPrime();
        boolean[] results = tsj.sieveOfEratosthenes(max);
        for (int i = 0; i < max + 1; i++) {
            if (results[i] && i >= 2) {
                System.out.println(i);
            }
        }
    }
}
