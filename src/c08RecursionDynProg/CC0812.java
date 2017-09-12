package c08RecursionDynProg;

import java.util.ArrayList;
import java.util.List;

/*
 * Eight Queens, all ways 8x8
 */
public class CC0812 {
    public List<Integer[]> eightQueens(int n) {
        List<Integer[]> resultList = new ArrayList<>();
        eightQueens(0, n, null, resultList);
        return resultList;
    }

    private void eightQueens(int r, int n, Integer[] columns, List<Integer[]> resultList) {
        if (r >= n) {
            resultList.add(columns.clone());
        }
        if (r == 0) {
            columns = new Integer[n];
        }
        for (int c = 0; c < n; c++) {
            if (isValid(r, c, columns)) {
                columns[r] = c;
                eightQueens(r + 1, n, columns, resultList);
            }
        }
    }

    private boolean isValid(int r, int c, Integer[] columns) {
        for (int r1 = 0; r1 < r; r1++) {
            if (columns[r1] == c) {
                return false;
            }
            if (Math.abs(columns[r1] - c) == (r - r1)) {
                return false;
            }
        }
        return true;
    }
}
