package com.day20;

import java.util.Arrays;

/**
 * @author cm
 * @create 2021/10/31-8:14 下午
 * 有序数组的平方
 * 输入：nums = [-4,-1,0,3,10]
 * 输出：[0,1,9,16,100]
 * 解释：平方后，数组变为 [16,1,0,9,100]
 * 排序后，数组变为 [0,1,9,16,100]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/squares-of-a-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SortedSquares {
    public static void main(String[] args) {
        int[] nums  = {-7,-3,2,3,11};
        int[] ints = sortedSquares(nums);
//        [-7,-3,2,3,11]
        System.out.println(Arrays.toString(ints));
    }
    public static int[] sortedSquares(int[] nums) {
        if (nums == null || nums.length == 0){
            return null;
        }
        int[] res = new int[nums.length];
        int index = nums.length-1;
        int L =0;
        int R = nums.length -1;
        while (L <= R){

            int l = nums[L]<0?-nums[L] : nums[L];
            int r = nums[R]<0?-nums[R] : nums[R];
            if (l > r){
                res[index--] = nums[L]* nums[L];
                L++;
            }
            if (l < r){
                res[index--] = nums[R]*nums[R];
                R--;
            }
            if (l == r  && L != R){
                res[index--] = nums[L]* nums[L];
                res[index--] = nums[R]*nums[R];
                L++;
                R--;
            }
            if (l == r  && L == R){
                res[index] = nums[R]*nums[R];
                R--;
            }
        }
        return res;
    }
}
