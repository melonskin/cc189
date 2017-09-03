package c10SortSearch;

/**
 * Created by SkinTang on 6/23/17.
 */
public class MergeSort {

    void mergeSort(int[] array) {
        int[] helper = new int[array.length];
        mergeSort(array, helper, 0, array.length-1);
    }

    void mergeSort(int[] array, int[] helper, int lo, int hi) {
        if (lo < hi) {
            int mid = (lo + hi) / 2;
            mergeSort(array, helper, lo, mid);
            mergeSort(array, helper, mid+1, hi);
            merge(array, helper, lo, mid, hi);
        }
    }

    void merge(int[] array, int[] helper, int lo, int mid, int hi) {
        for (int i = lo; i <= hi; i++) {
            helper[i] = array[i];
        }

        int helperLeft = lo;
        int helperRight = mid + 1;
        int current = lo;

        while ((helperLeft <= mid) && (helperRight <= hi)) {
            if (helper[helperLeft] < helper[helperRight]) {
                array[current] = helper[helperLeft];
                helperLeft++;
            } else {
                array[current] = helper[helperRight];
                helperRight++;
            }
            current++;
        }
        for (int i = helperLeft; i <= mid; i++) {
            array[current] = helper[i];
            current++;
        }
    }

    public static void main(String[] args) {
        MergeSort tsj = new MergeSort();
        int[] arr = {10,8,2,3,4,5,2,7,6,1,9};
        tsj.mergeSort(arr);
        for (int item : arr)
            System.out.println(item);
    }
}
