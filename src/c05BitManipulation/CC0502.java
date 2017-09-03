package c05BitManipulation;

/**
 * Created by SkinTang on 7/26/17.
 * Binary to String:
 * Given a real number between 0 and 1 (e.g., 0.72) that is passed in as a double,
 * print the binary representation. If the number cannot be represented accurately
 * in binary with at most 32 characters, print "ERROR."
 * Hints: 143, 167, 173, 269, 297
 */
public class CC0502 {

    public String doubleToBString(double in) {
        if (in >= 1.0 || in <= 0.0) {
            return "ERROR.";
        }
        int base = 10;
        int increaseBase = 1;
        Long num = 0L;
        while (in > 0) {
            Double temp = in * base;
            num += increaseBase * temp.intValue();
            increaseBase *= base;
            in = temp - temp.intValue();
        }
        int noBits = 0;
        StringBuilder sb = new StringBuilder();
        while (num != 0) {
            noBits++;
            if (noBits > 32) {
                return "ERROR.";
            }
            int nAtThisBit = (int) (num % 2);
            sb.append(nAtThisBit);
            num = num / 2;
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        CC0502 test = new CC0502();
        System.out.println(test.doubleToBString(0.00025));
        System.out.println(Integer.toBinaryString(52000));
    }
}
