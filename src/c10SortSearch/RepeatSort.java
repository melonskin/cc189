package c10SortSearch;

/**
 * Created by SkinTang on 6/25/17.
 */
class MergeSortTest {
    void mergeSort(int[] a) {
        int[] helper = new int[a.length];
        mergeSort(a, helper, 0, a.length-1);
    }
    void mergeSort(int[] a, int[] helper, int lo, int hi) {
        if (lo >= hi) return;
        int mid = (lo + hi) / 2;
        mergeSort(a, helper, lo, mid);
        mergeSort(a, helper, mid+1, hi);
        merge(a, helper, lo, mid, hi);
    }

    void merge(int[] a, int[] helper, int lo, int mid, int hi) {
        for (int i = lo; i <= hi; i++)
            helper[i] = a[i];
        int helperLeft = lo;
        int helperRight = mid + 1;
        int current = lo;
        while ((helperLeft <= mid) && (helperRight <= hi)) {
            if (helper[helperLeft] < helper[helperRight]) {
                a[current++] = helper[helperLeft++];
            } else {
                a[current++] = helper[helperRight++];
            }
        }
        for (int i = helperLeft; i <= mid; i++) {
            a[current++] = helper[i];
        }
    }
}

class QuickSortTest {
    void quickSort(int[] a) {
        quickSort(a, 0, a.length-1);
    }

    void quickSort(int[] a, int lo, int hi) {
        if (lo > hi - 1) return;
        int pivot = partition(a, lo, hi);
        quickSort(a, lo, pivot-1);
        quickSort(a, pivot+1, hi);
    }

    int partition(int[] a, int lo, int hi) {
        int left = lo;
        int right = hi + 1;
        while (true) {
            while (a[++left] < a[lo]) {
                if (left == hi) break;
            }
            while(a[--right] > a[lo]) {
                if (right == lo) break;
            }
            if (left >= right) break;
            swap(a, left, right);
        }
        swap(a, lo, right);
        return right;
    }

    void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}

public class RepeatSort {

    public static void main(String[] args) {
        MergeSortTest tsjm = new MergeSortTest();
        QuickSortTest tsjq = new QuickSortTest();
        int[] a = {2,5,7,1,9,8,8,4,5,2,3,7,10};
        int[] b = {2,5,7,1,9,8,8,4,5,2,3,7,10};

        tsjm.mergeSort(a);
        tsjq.quickSort(b);

        for (int it : a)
            System.out.println(it);

        System.out.println("2nd");

        for (int it : b)
            System.out.println(it);
    }
}
