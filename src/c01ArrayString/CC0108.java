package c01ArrayString;

/**
 * Created by SkinTang on 7/1/17.
 * Zero Matrix: Write an algorithm such that
 * if an element in an MxN matrix is 0, its entire row and column are set to 0.
 */
public class CC0108 {
    private void zeroMat(int[][] mat) {
        int nRow = mat.length;
        int nCol = mat[0].length;
        boolean[] rowMark = new boolean[nRow];
        boolean[] colMark = new boolean[nCol];
        for (int i = 0; i < nRow; i++) {
            for (int j = 0; j < nCol; j++) {
                if (mat[i][j] == 0) {
                    rowMark[i] = true;
                    colMark[j] = true;
                }
            }
        }
        for (int i = 0; i < nRow; i++) {
            if (rowMark[i]) {
                for (int j = 0; j < nCol; j++) {
                    mat[i][j] = 0;
                }
            }
        }
        for (int j = 0; j < nCol; j++) {
            if (colMark[j]) {
                for (int i = 0; i < nRow; i++) {
                    mat[i][j] = 0;
                }
            }
        }
    }

    private void zeroMatInPlace(int[][] mat) {
        int nRow = mat.length;
        int nCol = mat[0].length;
        int colMarkFirst = 1;
        for (int i = 0; i < nRow; i++) {
            if (mat[i][0] == 0) {
                colMarkFirst = 0;
                break;
            }
        }
        for (int i = 0; i < nRow; i++) {
            for (int j = 1; j < nCol; j++) {
                if (mat[i][j] == 0) {
                    mat[i][0] = 0;
                    mat[0][j] = 0;
                }
            }
        }
        // can set zero like upper
        for (int i = 1; i < nRow; i++) {
            for (int j = 1; j < nCol; j++) {
                if (mat[0][j] == 0 || mat[i][0] == 0) {
                    mat[i][j] = 0;
                }
            }
        }
        if (mat[0][0] == 0) {
            for (int j = 1; j < nCol; j++){
                mat[0][j] = 0;
            }
        }
        if (colMarkFirst == 0) {
            for (int i = 0; i < nRow; i++) {
                mat[i][0] = 0;
            }
        }


    }
}
