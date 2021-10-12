package com.datastructure.other;


import com.datastructure.sort.Swap;

/**
 * 给定一个数组，然后给定一个数，然后小于这个数的放左边，大于这个数的放右边，等于这个数的放在中间
 */
public class HeLanArr {

    public static void main(String[] args) {

//        int[] arr = {1,4,2,6,3,4,5,1,7,1,3,4};
        int[] arr = {1, 5, 2, 3, 4, 5, 6};
        int[] ints = heLanArr(arr, 0, arr.length - 1, 4);
        int[] partition = partition(arr, 0, arr.length - 1, 4);
        Swap.printArr(ints);
        Swap.printArr(partition);
    }

    public static int[] heLanArr(int[] arr, int L, int R, int num) {
        int less = L - 1;
        int more = R + 1;
        int cur = L;
        while (cur < more) {
            if (arr[cur] < num) {
                Swap.swap(arr, ++less, cur++);
            } else if (arr[cur] > num) {
                Swap.swap(arr, --more, cur);
            } else {
                cur++;
            }
        }
        System.out.println(less + "==" + more);
        return new int[]{less + 1, more - 1};
    }

    public static int[] partition(int[] arr, int L, int R, int p) {
        int less = L - 1;
        int more = R + 1;
        while (L < more) {
            if (arr[L] < p) {
                swap(arr, ++less, L++);
            } else if (arr[L] > p) {
                swap(arr, --more, L);
            } else {
                L++;
            }
        }
        return new int[]{less + 1, more - 1};
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
