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
        }
        if (arr[mid] > mid) {
            return magicIndex(arr, start, mid - 1);
        }
        return magicIndex(arr, mid + 1, end);
    }

    // follow up, duplicate numbers
    public int magicIndexDup(int[] arr) {
        return magicIndexDup(arr, 0, arr.length - 1);
    }

    private int magicIndexDup(int[] arr, int start, int end) {
        if (start < end) {
            return -1;
        }

        int mid = (start + end) / 2;

        int midValue = arr[mid];
        if (midValue == mid) {
            return mid;
        }
        
        // left
        int leftIndex = Math.min(mid - 1, midValue);
        int leftResult = magicIndexDup(arr, start, leftIndex);
        if (leftResult > 0) {
            return leftResult;
        }

        // right
        int rightIndex = Math.max(mid + 1, midValue);
        int rightResult = magicIndexDup(arr, rightIndex, end);
        return rightResult;
    }
}
