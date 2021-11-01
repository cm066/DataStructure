package com.niukelearn;

/**
 * @author cm
 * @create 2021/10/14-11:05 下午
 *数轴覆盖问题
 */
public class MaxPoint {
    public static void main(String[] args) {
        int[] arr = {2,7,15,19,23,34};
        int i = maxPoint(arr, 8);
        System.out.println(i);
        int i1 = maxPoint1(arr, 8);
        System.out.println(i1);
//        String s = "46 118 157 162 236 265 348 411 478 547 557 607 693 725 791 887 987 1034 1066 1107 1203 1212 1219 1277 1374 1461 1487 1508 1531 1631 1683 1714 1790 1833 1907 1924 1996 2100 2140 2239 2247 2263 2290 2328 2406 2475 2521 2537 2595 2668";
//        System.out.println(s.replace(" ", ","));
        int[] arr2 = {46,118,157,162,236,265,348,411,478,547,557,607,693,725,791,887,
                987,1034,1066,1107,1203,1212,1219,1277,1374,1461,1487,1508,1531,1631,
                1683,1714,1790,1833,1907,1924,1996,2100,2140,2239,2247,2263,2290,2328,2406,2475,2521,2537,2595,2668};
        System.out.println(maxPoint1(arr2, 50));
        System.out.println(maxPoint1(arr2, 60));
    }

    /**
     * 最优解法
     * @param arr
     * @param L
     * @return
     */
    public static int maxPoint1(int[] arr,int L){
        int left = 0;
        int right = 0;
        int n = arr.length;
        int max =0;
        while (left < n){
            while (right < n && arr[right] - arr[left] <= L){
                right++;
            }
            max = Math.max(max,right - (left++));
        }
        return max;
    }

    /**
     * 这个采用的是二分法的方式来用的
     * @param arr
     * @param L
     * @return
     */
    public static int maxPoint(int[] arr,int L){
        int res = 1;
        for (int i = 0; i < arr.length; i++) {
            int nearnest = nearnestIndex(arr, i, arr[i] - L);
            res = Math.max(res,i-nearnest+1);
        }
        return res;
    }
    public static int nearnestIndex(int[] arr,int R,int value){
        int L = 0;
        int index =R;
        while (L <= R){
            int mid = L + ((R -L)>>1);
            if (arr[mid] >= value){
                index = mid;
                R = mid -1;
            }else {
                L = mid+1;
            }
        }
        return index;
    }
}
