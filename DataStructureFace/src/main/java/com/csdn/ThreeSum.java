package com.csdn;


import java.util.*;

/**
 * 在一个数组里面，是否有存在三个数相加然后和为零的
 */
public class ThreeSum {
    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        List<List<Integer>> lists = threeSum1(nums);
        System.out.println(lists);
    }


    public static List<List<Integer>> threeSum1(int[] num) {
        Arrays.sort(num); //排序
        List<List<Integer>> res = new LinkedList<>();
        for (int i = 0; i < num.length-2; i++) {
            //为了保证不加⼊重复的 list,因为是有序的，所以如果和前⼀个元素相同，只需要继续后移就可以
            if (i == 0 || (i > 0 && num[i] != num[i-1])) {
                int lo = i + 1, hi = num.length - 1, sum = 0 - num[i];
                while (lo < hi) {
                    if (num[lo] + num[hi] == sum) {
                        res.add(Arrays.asList(num[i], num[lo], num[hi]));
                        while (lo < hi && num[lo] == num[lo + 1]) lo++;
                        while (lo < hi && num[hi] == num[hi - 1]) hi--;
                        lo++;
                        hi--;
                    } else if (num[lo] + num[hi] < sum) lo++;
                    else hi--;
                }
            }
        }
        return res;
    }
    /**
     * 暴力递归，复杂度太高
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                for (int k = j+1; k < nums.length; k++) {
                    List<Integer> tmp= new ArrayList<>();
                    int sum = nums[i]+nums[j]+nums[k];
                    if (sum == 0){
                        tmp.add(nums[i] );
                        tmp.add(nums[j] );
                        tmp.add(nums[k]);
                        if (isInList(res,tmp)){
                            continue;
                        }
                        res.add(tmp);
                    }
                }
            }
        }
        return res;
    }


    /**
     * 判断这个集合里面是否已经存在这个集合
     * @param l
     * @param a
     * @return
     */
    public static boolean isInList(List<List<Integer>> l, List<Integer> a) {
        for (int i = 0; i < l.size(); i++) {
            if (isSame(l.get(i),a)){
                return true;
            }
        }
        return false;
    }

    /**
     * 判断当前加进来的集合，和集合的中的任何一个集合是否相同
     * @param a
     * @param b
     * @return
     */
    public static boolean isSame(List<Integer> a, List<Integer> b) {
        Collections.sort(a);
        Collections.sort(b);
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i) != b.get(i)){
                return false;
            }
        }
        return true;
    }
}
