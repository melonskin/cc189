package c01ArrayString;

import java.util.HashMap;
import java.util.Arrays;

/**
 * Created by SkinTang on 6/13/17.
 */

// estimate whether one string is a permutation of another
public class CC0102 {
    // HashMap solution
    private boolean isStrPermutationMap(String str1, String str2) {
        if (str1.length() != str2.length()) return false;
        HashMap<Integer, Integer> charMap = new HashMap<>();
        for (int i = 0; i < str1.length(); i++) {
            int aChar = str1.charAt(i);
            if (!charMap.containsKey(aChar)) {
                charMap.put(aChar, 0);
            }
            int count = charMap.get(aChar) + 1;
            charMap.put(aChar, count);
        }

        for (int i = 0; i < str2.length(); i++) {
            int aChar = str2.charAt(i);
            if (!charMap.containsKey(aChar)) return false;
            int count = charMap.get(aChar) - 1;
            charMap.put(aChar, count);
        }

        for(Integer value: charMap.values()) {
            if (value != 0) return false;
        }
        return true;
    }

    // use array to store
    private boolean isStrPermutationArray(String str1, String str2) {
        if (str1.length() != str2.length()) return false;
        int[] charCount = new int[128];
        for (int i = 0; i < str1.length(); i++) {
            int pos1 = str1.charAt(i);
            charCount[pos1]++;
            int pos2 = str2.charAt(i);
            charCount[pos2]--;
        }
        for (int i = 0; i < 128; i++) {
            if (charCount[i] != 0) return false;
        }
        return true;
    }

    private String stringSort(String str) {
        char[] charArr = str.toCharArray();
        Arrays.sort(charArr);
        return String.valueOf(charArr);
    }
    private boolean isStrPermutationSort(String str1, String str2) {
        if (str1.length() != str2.length()) return false;
        str1 = stringSort(str1);
        str2 = stringSort(str2);

        return (str1.equals(str2));

    }

    public static void main(String[] args) {
        String str1 = "aabaab";
        String str2 = "aaaaba";
        CC0102 tsj = new CC0102();
        boolean isPermutation = tsj.isStrPermutationArray(str1, str2);
        System.out.println(isPermutation);
    }
}
