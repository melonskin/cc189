package c01ArrayString;

/**
 * Created by SkinTang on 7/1/17.
 * There are three types of edits that can be performed on strings:
 * insert a character, remove a character, or replace a character.
 * Given two strings, write a function to check if they are one edit (or zero edits) away.
 */
public class CC0105 {

    private boolean verifyOneAwaySinglePass(String a, String b) {
        int aLen = a.length();
        int bLen = b.length();
        if (Math.abs(aLen - bLen) > 1) return false;
        boolean foundDiff = false;
        int ai = 0, bi = 0;
        while ((ai < aLen) && (bi < bLen)) {
            if (a.charAt(ai) != b.charAt(bi)) {
                if (foundDiff) {
                    return false;
                }
                foundDiff = true;
                if (aLen < bLen) {
                    bi++;
                } else if (aLen > bLen){
                    ai++;
                }
            } else {
                ai++;
                bi++;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        CC0105 test = new CC0105();
        String a = "pale";
        String b = "bake";
        System.out.println(test.verifyOneAwaySinglePass(a, b));

    }
}
