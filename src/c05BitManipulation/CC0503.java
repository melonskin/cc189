package c05BitManipulation;

/**
 * Created by SkinTang on 7/26/17.
 * Flip Bit to Win:
 * You have an integer and you can flip exactly one bit from a 0 to a 1.
 * Write code to find the length of the longest sequence of 1s you could create.
 * EXAMPLE:
 * Input: 1775 (or: 11011101111)
 * Output: 8
 *
 * Hints: 159, 226, 314, 352
 */
public class CC0503 {
    public int flipBit(int in) {
        int totalBits = Integer.bitCount(in);
        int prevOneNum = 0;
        int oneNum = 0;
        int prevZeroPos = -1;
        int maxOneNum = 0;
        int maxOnePos = 0;
        for (int i = 0; i <= totalBits; i++) {
            if (getBit(in, i)) {
                oneNum++;
            } else {
                int thisOneNum = prevOneNum + oneNum;
                //TODO, last zero
                if ((prevZeroPos != -1) && thisOneNum > maxOneNum) {
                    maxOneNum = thisOneNum;
                    maxOnePos = prevZeroPos;
                }
                prevOneNum = oneNum;
                prevZeroPos = i;
                oneNum = 0;
            }
        }
        int lastOneNum = oneNum + prevOneNum;
        return (lastOneNum > maxOneNum) ? lastOneNum + 1 : maxOneNum + 1;
    }

    private boolean getBit(int in, int pos) {
        return (in & (1 << pos)) > 0;
    }

    public static void main(String[] args) {
        CC0503 test = new CC0503();
        System.out.println(test.flipBit(1775));
    }
}
