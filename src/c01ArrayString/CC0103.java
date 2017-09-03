package c01ArrayString;

/**
 * Created by SkinTang on 6/14/17.
 */
/* URLify, substitute all space with '%20'
 * input: string: "Mr John Smith   "; true length of final string: 13
 * output: string: "Mr%20John%20Smith"
 * use char[] to do it in place
*/
public class CC0103 {
    private void uRLify(char[] charArr, int trueLength) {
        int noSpace = 0;
        for (int i = 0; i < trueLength; i++) {
            if (charArr[i] == ' ') noSpace++;
        }
        int index = trueLength + 2 * noSpace;
        if (trueLength < charArr.length) charArr[trueLength] = '\0';
        for (int i = trueLength - 1; i >=0; i--){
            if (charArr[i] == ' ') {
                charArr[index-1] = '0';
                charArr[index-2] = '2';
                charArr[index-3] = '%';
                index -= 3;
            } else {
                charArr[index-1] = charArr[i];
                index--;
            }
        }

    }

    public static void main(String[] args) {
        char[] charArr = "Mr John Smith         ".toCharArray();
        CC0103 test = new CC0103();
        System.out.println(":" + String.valueOf(charArr) + ":");
        test.uRLify(charArr, 13);
        System.out.println(":" + String.valueOf(charArr) + ":");
    }
}
