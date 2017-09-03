package c10SortSearch;

/**
 * Created by SkinTang on 6/27/17.
 */
public class BinarySearch {
    public int searchIterative(int[] arr, int x) {
        int lo = 0;
        int hi = arr.length - 1;

        while (lo <= hi) {
            int mid = (hi + lo) / 2;
            if (arr[mid] > x) {
                hi = mid - 1;
            } else if (arr[mid] < x) {
                lo = mid + 1;
            } else {
                return mid;
            }
        }
        return -999;
    }

    public int searchRecursive(int[] arr, int x) {
        return searchRecursive(arr, x, 0, arr.length - 1);
    }
    public int searchRecursive(int[] arr, int x, int lo, int hi) {
        if (lo > hi) return -999;
        int mid = (lo + hi) / 2;
        if (arr[mid] > x) {
            return searchRecursive(arr, x, lo, mid - 1);
        } else if (arr[mid] < x) {
            return searchRecursive(arr, x, mid + 1, hi);
        }
        return mid;
    }

    public static void main(String[] args) {
        BinarySearch tsj = new BinarySearch();
        int[] a = {1,2,4,6,8,10,15,87,102};
        System.out.println(tsj.searchIterative(a, 15));
        System.out.println(tsj.searchIterative(a, 105));
        System.out.println(tsj.searchRecursive(a, 15));
        System.out.println(tsj.searchRecursive(a, 105));

    }

}


