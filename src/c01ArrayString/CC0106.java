package c01ArrayString;

/**
 * Created by SkinTang on 7/1/17.
 * String Compression:
 * Implement a method to perform basic string compression using the counts of repeated characters.
 * For example, the string aabcccccaaa would become a2b1c5a3.
 * If the "compressed" string would not become smaller than the original string,
 * your method should return the original string.
 * You can assume the string has only uppercase and lowercase letters (a - z).
 */
public class CC0106 {

    private String strCompress(String str) {
        char[] strCh = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        int left = 0;
        int right = 0;
        int count = 0;
        while (right < strCh.length) {
            if (strCh[left] == strCh[right]) {
                right++;
                count++;
            } else {
                sb.append(strCh[left]).append(count);
                count = 0;
                left = right;
            }
        }
        sb.append(strCh[left]).append(count);
        if (sb.toString().length() < str.length()) {
            return sb.toString();
        } else {
            return str;
        }
    }

    private String strCompress2(String str) {
        int count = 0;
        int finalLength = getCompressedLength(str);
        if (finalLength >= str.length()) {
            return str;
        }
        StringBuilder sb = new StringBuilder(finalLength);
        for (int i = 0; i < str.length(); i++) {
            count++;
            if (i == str.length() - 1 || str.charAt(i) != str.charAt(i+1)) {
                sb.append(str.charAt(i)).append(count);
                count = 0;
            }
        }
        return sb.toString();
    }

    private int getCompressedLength(String str) {
        int count = 0;
        int finalLength = 0;
        for (int i = 0; i < str.length(); i++) {
            count++;
            if (i >= str.length() - 1 || str.charAt(i) != str.charAt(i+1)) {
                finalLength += 1 + String.valueOf(count).length();
                count = 0;
            }
        }
        return finalLength;
    }

    public static void main(String[] args) {
        String str = "aaaaaabbbcd";
        CC0106 test = new CC0106();
        System.out.println(test.strCompress2(str));
    }
}
