package c01ArrayString;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SkinTang on 6/12/17.
 */
public class SearchTwoSortedLists {
    public static void main(String[] args) {
        int[] a1 = {13, 27, 35, 40, 49, 55, 59, 60, 61, 63};
        int[] a2 = {17, 35, 39, 40, 55, 58, 60};
        Integer[] a3 = new Integer[a1.length + a2.length];
        int ind1 = 0;
        int ind2 = 0;
        int ind3 = 0;
//        while (true) {
//            if (ind1 == a1.length && ind2 == a2.length )
//                break;
//            else if (ind1 == a1.length) {
//                while (ind2 < a2.length) {
//                    a3[ind3++] = a2[ind2];
//                }
//                break;
//            } else if (ind2 == a2.length) {
//                while (ind1 < a1.length) {
//                    a3[ind3] = a1[ind1];
//                    ind1++;
//                    ind3++;
//                }
//                break;
//            }
//
//            if (a1[ind1] == a2[ind2]) {
//                a3[ind3] = a1[ind1];
//                ind1++;
//                ind2++;
//                ind3 += 1;
//            } else if (a1[ind1] > a2[ind2]) {
//                a3[ind3] = a2[ind2];
//                ind2++;
//                ind3++;
//            } else {
//                a3[ind3] = a1[ind1];
//                ind1++;
//                ind3++;
//            }
//        }

        while (ind1 < a1.length && ind2 < a2.length) {

            // allow duplicate
//            if (a1[ind1] < a2[ind2])
//                a3[ind3++] = a1[ind1++];
//            else
//                a3[ind3++] = a2[ind2++];

            // not allow duplicate

            if (a1[ind1] == a2[ind2]) {
                a3[ind3++] = a1[ind1++];
                ind2++;
            } else if (a1[ind1] < a2[ind2])
                a3[ind3++] = a1[ind1++];
            else
                a3[ind3++] = a2[ind2++];
        }

        while (ind1 < a1.length)
            a3[ind3++] = a1[ind1++];

        while (ind2 < a2.length)
            a3[ind3++] = a2[ind2++];

        for (Integer a : a3) {
            System.out.println(a);
        }
    }
}
