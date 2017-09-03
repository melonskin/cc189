package c05BitManipulation;

/**
 * Created by SkinTang on 6/19/17.
 */
public class BitTest {

    void rightShift() {
        int numA = -93242;
        int count = 40;
        int numL = numA;
        for (int i = 0; i < count; i++) {
            numA >>= 1;
            numL >>>= 1;
            System.out.println("Arithemic result: " + numA);
            System.out.println("Logic result: " + numL);
        }
    }

    boolean getBit(int num, int i) {
        return ((num & (1 << i)) > 0);
    }

    int setBit(int num, int i) {
        return num | (1 << i);
    }

    int clearBit(int num, int i) {
        int mask = ~(1 << i);
        return num & mask;
    }

    int clearBitsMSBthroughI(int num, int i) {
        int mask = (1 << i) - 1;
        return num & mask;

    }

    int clearBitsIthrough0(int num, int i) {
        int mask = -1 << (i+1);
        return num & mask;
    }

    int updateBit(int num, int i, boolean bitIsOne) {
        int val = (bitIsOne) ? 1 : 0;
        int mask = ~(1 << i);
        return (num & mask) | (val << i);
    }

    public static void main(String[] args) {
        int no = ~0;
        System.out.println(no << 1);
        System.out.println(no << 3);
    }
}
