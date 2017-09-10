package c08RecursionDynProg;

/*
 * Magic Index
 *
 */
public class CC0803 {
    public int magicIndex(int[] arr) {
        return magicIndex(arr, 0, arr.length - 1);
    }
    private int magicIndex(int[] arr, int start, int end) {
        if (end < start) {
            return -1;
        }
        int mid = (start + end) / 2;
        if (arr[mid] == mid) {
            return mid;
        } else if (arr[mid] > mid) {
            return magicIndex(arr, start, mid - 1);
        } else {
            return magicIndex(arr, mid + 1, end);
        }
    }
}
