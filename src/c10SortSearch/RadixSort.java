package c10SortSearch;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by SkinTang on 6/25/17.
 */
public class RadixSort {
    void radixSort(int[] arr, int maxDigits) {
        HashMap<Integer, Queue<Integer>> map = new HashMap<>();
        for (int i = 1; i <= maxDigits; i++) {
            if (i == 1) {
                for (int item : arr) {
                    putInMap(map, item, i);
                }

            } else {
                HashMap<Integer, Queue<Integer>> tempMap = new HashMap<>();
                for (int j = 0; j <= 9; j++) {
                    if (map.containsKey(j)) {
                        Queue<Integer> list = map.get(j);
                        while (!list.isEmpty()) {
                            Integer item = list.remove();
                            putInMap(tempMap, item, i);
                        }
                    }
                }
                map = tempMap;
            }
        }
        // get
        int current = 0;
        for (int j = 0; j <=9; j++) {
            if (map.containsKey(j)) {
                Queue<Integer> list = map.get(j);
                while (!list.isEmpty()) {
                    Integer item = list.remove();
                    arr[current++] = item;
                }
            }
        }
    }

    int getDigit(int num, int pos) {
        return (num / (int) Math.pow(10, pos - 1) % 10);
    }

    void putInMap(HashMap<Integer, Queue<Integer>> map, int item, int noDigit) {
        int digit = getDigit(item, noDigit);
        Queue<Integer> list;
        if (!map.containsKey(digit)) {
            list = new LinkedList<>();
        } else {
            list = map.get(digit);
        }
        list.add(item);
        map.put(digit,list);

    }

    public static void main(String[] args) {
        RadixSort tsj = new RadixSort();
        int[] arr = {10,8,11,34,26,11,2,3,4,5,2,7,6,1,9,104};
        tsj.radixSort(arr,3);
        for (int item : arr) {
            System.out.println(item);
        }
//        System.out.println(tsj.getDigit(11, 2));

    }
}
