package c10SortSearch;

import java.util.Collections;
import java.util.Comparator;

/**
 * Created by SkinTang on 6/24/17.
 */

class IntegerComparator implements Comparator<Integer> {
    @Override
    public int compare(Integer a, Integer b) {
        return (b - a);
    }
}

public class QuickSort {
    void quickSort(int[] a) {
        quickSort(a, 0, a.length-1);
    }
    void quickSort(int[] a, int lo, int hi) {
        int pivot = partition(a, lo, hi);
        if (lo < pivot - 1)
            quickSort(a, lo, pivot - 1);
        if (pivot < hi)
            quickSort(a, pivot, hi);
    }
    int partition(int[] a, int lo, int hi) {
        int piv = a[(lo + hi)/2];
        int left = lo;
        int right = hi;
        while (left <= right) {
            while (a[left] < piv) left++;
            while (a[right] > piv) right--;
            if (left <= right) {
                int temp = a[left];
                a[left] = a[right];
                a[right] = temp;
                left++;
                right--;
            }
        }
        return left;
    }

    boolean less(Integer[] a, int left, int right) {
        return (a[left] < a[right]);
    }

    void swap(Integer[] a, int left, int right) {
        Integer temp = a[right];
        a[right] = a[left];
        a[left] = temp;
    }

    void quickSortP(Integer[] a) {
        quickSortP(a, 0, a.length-1);
    }
    void quickSortP(Integer[] a, int lo, int hi) {
        if (lo > hi - 1) return;
        int pivot = partitionP(a, lo, hi);
        quickSortP(a, lo, pivot - 1);
        quickSortP(a, pivot + 1, hi);
    }
    int partitionP(Integer[] a, int lo, int hi) {
        int left = lo;
        int right = hi + 1;
        while (true) {
            while (less(a, ++left, lo)) {
                if (left == hi)
                    break;
            }
            while (less(a, lo, --right)) {
                if (right == lo)
                    break;
            }
            if (left >= right ) break;
            swap(a,left,right);
        }
        swap(a,lo,right);
        return right;

    }


    public static void main(String[] args) {
        QuickSort tsj = new QuickSort();
        int[] a = {2,5,7,1,9,8,8,4,5,2,3,7,10};
        tsj.quickSort(a);
        for (int item : a) {
            System.out.println(item);
        }
        System.out.println("2nd");
        Integer[] b = {2,5,7,1,9,8,8,4,5,2,3,7,10};
        tsj.quickSortP(b);
        for (Integer it : b) {
            System.out.println(it);
        }
    }
}
