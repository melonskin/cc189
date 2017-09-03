package c01ArrayString;

import java.util.HashSet;

/**
 * Created by SkinTang on 6/13/17.
 */

public class CC0101 {

    private boolean isUniqueChars(String str) {
        if (str.length() > 128) return false;

        boolean[] uniqueFlag = new boolean[128];

        for (int i = 0; i < str.length(); i++) {
            int pos = str.charAt(i);
            if (uniqueFlag[pos]) return false;
            uniqueFlag[pos] = true;
        }
        return true;
    }

    private boolean isUniqueCharsBit(String str) {
        int checker = 0;
        for (int i = 0; i < str.length(); i++) {
            int pos = str.charAt(i) - 'a';
            if ((checker & (1 << pos)) > 0) return false;
            checker |= (1 << pos);
        }
        return true;
    }

    private boolean isUniqueCharsMap(String str) {
        HashSet<Integer> charsMap = new HashSet<>();
        for (int i = 0; i < str.length(); i++) {
            int aChar = str.charAt(i);
            if (charsMap.contains(aChar)) return false;
            charsMap.add(aChar);
        }
        return true;
    }


}
