package c01ArrayString;

/**
 * Created by SkinTang on 7/1/17.
 * Given an image represented by an NxN matrix, where each pixel in the image is 4 bytes,
 * write a method to rotate the image by 90 degrees. Can you do this in place?
 * : layer by layer, from outermost to innermost
 */
public class CC0107 {
    private void rotate(int[][] mat) {
        int len = mat.length;
        int NoLayer = len / 2;
        int first = -1;
        int last = len;
        for (int i = NoLayer; i > 0; i--) {
            first++;
            last--;
            for (int j = first; j <= last - 1; j++) {
                int temp = mat[first][j];
                mat[first][j] = mat[len - 1 - j][first];
                mat[len - 1 - j][first] = mat[last][len - 1 - j];
                mat[last][len - 1 - j] = mat[j][last];
                mat[j][last] = temp;
            }

        }
    }

    private static void printMat(int[][] a) {
        int len = a.length;
        System.out.println(len);
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                System.out.print(a[i][j]);
                System.out.print(" ");
            }
            System.out.println();

        }
    }

    public static void main(String[] args) {
        int[][] a = {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20}, {21, 22, 23, 24, 25}};
        printMat(a);
        CC0107 test = new CC0107();
        test.rotate(a);
        printMat(a);
    }

}
