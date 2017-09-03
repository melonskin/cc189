package c10SortSearch;

/**
 * Created by SkinTang on 6/24/17.
 */
public class QuickSortPrinceton {
    void quickSort(int[] a) {
        quickSort(a, 0, a.length-1);
    }

    void quickSort(int[] a, int left, int right) {
        if (left > right - 1) return;
        int pivot = partition(a, left, right);
        quickSort(a, left, pivot-1);
        quickSort(a, pivot+1, right);
    }

    int partition(int[] a, int left, int right) {
        int i = left;
        int j = right + 1;
        while (true) {
            while (a[++i] < a[left]) {
                if (i == right) break;
            }
            while (a[--j] > a[left]) {
                if (j == left) break;
            }
            if (i >= j) break;
            swap(a, i, j);
        }
        swap(a, left, j);
        return j;
    }

    void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) {
        QuickSortPrinceton tsj = new QuickSortPrinceton();
        int[] a = {2,5,7,1,9,8,8,4,5,2,3,7,10};
        tsj.quickSort(a);
        for (int item : a) {
            System.out.println(item);
        }
    }
}
