package com.datastructure.sort;

public class BinarySearchNoRecur {

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 6, 8, 9, 10};
        int i = binarySearch(arr, 6);
        System.out.println(i);
        System.out.println("递归方法实现");
        int i1 = binarySearchRecur(arr, 0, arr.length - 1, 6);
        System.out.println(i1);
    }

    /**
     * 非递归版本的二分查找
     *
     * @param arr
     * @param target
     * @return
     */
    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    public static int binarySearchRecur(int[] arr, int left, int right, int target) {
        if (left > right) {
            return -1;
        } else {
            int mid = left + (left + right) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                return binarySearchRecur(arr, mid + 1, right, target);
            } else {
                return binarySearchRecur(arr, left, mid - 1, target);
            }
        }
    }
}
