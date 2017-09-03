package c01ArrayString;

/**
 * Created by SkinTang on 6/14/17.
 */
// if permutation of a palindrome
public class CC0104 {
    private boolean isPermPalindrome(String str) {
        int[] charArr = new int[128];
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') continue;
            int pos = str.charAt(i);
            charArr[pos]++;
        }
        boolean hasFoundOdd = false;
        for (int count : charArr) {
            if (count % 2 != 0) {
                if (hasFoundOdd) return false;
                else hasFoundOdd = true;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        CC0104 test = new CC0104();
        String str = "taco act";
        System.out.println(test.isPermPalindrome(str));
    }
}
