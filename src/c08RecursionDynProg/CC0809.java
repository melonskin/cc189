package c08RecursionDynProg;

import java.util.ArrayList;
import java.util.List;

/*
 * Parens
 */
public class CC0809 {
    public List<String> generateAllParens(int n) {
        char[] charArr = new char[2 * n];
        List<String> resultList = new ArrayList<>();

        getParens(resultList, n, n, charArr, 0);
        return resultList;
    }

    private void getParens(List<String> resultList, int leftRemain, int rightRemain,
                           char[] charArr, int index) {
        if (leftRemain < 0 || leftRemain > rightRemain) {
            return;
        }
        if (leftRemain == 0 && rightRemain == 0) {
            resultList.add(String.valueOf(charArr));
            return;
        }
        charArr[index] = '(';
        getParens(resultList, leftRemain - 1, rightRemain, charArr, index + 1);

        charArr[index] = ')';
        getParens(resultList, leftRemain, rightRemain - 1, charArr, index + 1);
    }
}
