package c05BitManipulation;

/**
 * Created by SkinTang on 7/26/17.
 * Insertion:
 * You are given two 32-bit numbers, N and M, and two bit positions,
 * i and j. Write a method to insert M int N such that M start at bit j
 * and ends at bit i. Given i and j are valid.
 * EXAMPLE:
 * Input: N = 10000000000, M = 10011, i = 2, j = 6
 * Output: N = 10001001100
 *
 * Hints: 137, 169, 215
 */
public class CC0501 {
    public int insert(int n, int m, int i, int j) {
        int numBitsM = numBits(m);
        int noBitsM = numBitsM - 1;
        for (int x = j; x > (j-numBitsM); x--) {
            int newBit = getBit(m, noBitsM--) ? 1 : 0;
            n = updateBit(n, x, newBit);
        }
        return n;
    }

    private int numBits(int m) {
        int numBits = 0;
        for (int i = 0; i < 32; i++) {
            if (getBit(m, i)) {
                numBits = i;
            }
        }
        return numBits + 1;
    }
    private boolean getBit(int m, int i) {
        return (m & (1 << i)) > 0;
    }

    private int updateBit(int n, int i, int newBit) {
        int mask = ~(1 << i);
        return (n & mask) | (newBit << i);
    }

    public int insert2(int n, int m, int i, int j) {
        int numBitsM = numBits(m);
        int mask = ~((1 << (j+1)) - 1);
        mask = mask | ~(-1 << i);
        return (n & mask) | (m << i + (j - numBitsM - 1));
    }

    public static void main(String[] args) {
        CC0501 test = new CC0501();
        int n = 0b10000000000;
        int m = 0b10011;
        int result = test.insert2(n, m, 2, 6);
        System.out.println(Integer.toBinaryString(result));
    }
}
