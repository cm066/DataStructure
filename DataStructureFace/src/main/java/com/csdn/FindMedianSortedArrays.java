package com.csdn;


/**
 * 两个有序的数组，找其两个数组的中位数
 */
public class FindMedianSortedArrays {

    public static void main(String[] args) {
        int[] arr1 = {1, 3, 5, 6};
        int[] arr2 = {1, 2, 7, 8};
        System.out.println(findMedianSortedArrays1(arr1, arr2));
    }

    /**
     * 第一种算法是将两个数组合并起来，然后看是基数个还是偶数个
     * 若是奇数个，就是总长度的
     * 这样做的时间复杂度是O（m+n）因为要遍历完整个数组
     * 空间复杂度也是（m+n）
     *
     * @param arr1
     * @param arr2
     * @return
     */
    public static double findMedianSortedArrays(int[] arr1, int[] arr2) {
        double res = 0;
        int[] arr = new int[arr1.length + arr2.length];
        int index = 0;//合并数组的下标
        int a1 = arr1.length;
        int a2 = arr2.length;
        int i = 0;
        int j = 0;
        while (i < a1 && j < a2) {
            if (arr1[i] <= arr2[j]) {
                arr[index++] = arr1[i++];
            } else {
                arr[index++] = arr2[j++];
            }
        }
        if (i < a1) {
            //说明arr1还没有遍历完
            while (i < a1) {
                arr[index++] = arr1[i++];
            }
        }
        if (j < a2) {
            while (j < a2) {
                arr[index++] = arr2[j++];
            }
        }

        int length = arr.length;
        if (length % 2 != 0) {
            res = arr[length / 2] / 2.0;
        } else {
            //就是偶数个
            res = (arr[length / 2 - 1] + arr[length / 2]) / 2.0;
        }
        return res;
    }

    /**
     * 其实在遍历的时候就可以找出中位数，但是首先要看宗总的个数是奇数个还是偶数个
     * 若是奇数个就直接遍历到总长度的中间即可，若是偶数个还需要用一个变量记录下上一个数
     *
     * @param arr1
     * @param arr2
     * @return
     */
    public static double findMedianSortedArrays1(int[] arr1, int[] arr2) {
        double res = 0;
        int n = (arr1.length + arr2.length);
        int end = n / 2;
        int index = 0;
        int j = 0;
        int i = 0;
        int left = 0;
        int right = 0;
        while (index <= end) {
            left = right;
            if (i < arr1.length && (j >= arr2.length || arr1[i] < arr2[j])) {
                right = arr1[i++];
                index++;
            } else {
                right = arr2[j++];
                index++;
            }
        }
        if (n % 2 != 0) {
            //奇数个，直接right/2.0
            res = right / 2.0;
        } else {
            res = (left + right) / 2.0;
        }
        return res;
    }
}
