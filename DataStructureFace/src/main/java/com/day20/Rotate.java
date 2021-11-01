package com.day20;

import java.util.Arrays;

/**
 * @author cm
 * @create 2021/10/31-10:19 下午
 *输入: nums = [1,2,3,4,5,6,7], k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右旋转 1 步: [7,1,2,3,4,5,6]
 * 向右旋转 2 步: [6,7,1,2,3,4,5]
 * 向右旋转 3 步: [5,6,7,1,2,3,4]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/rotate-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * todo
 */
public class Rotate {
    public static void main(String[] args) {
        int[] nums = {-1,-100,3,99};
        int[] nums1 = {1,2,3,4,5,6,7};
        rotate(nums1,3);
        System.out.println(Arrays.toString(nums1));
    }
    //[3,99,-1,-100]
    public static void rotate(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k < 0){
            return;
        }
        int L = 0;
        int R  = nums.length % 2 != 0?k+1:k;
       while (R < nums.length){
           int a = nums[L];
           nums[L] = nums[R];
           nums[R] = a;
           L++;
           R++;
       }
       if (nums.length %2 != 0){
           R = k+1;
           while (R < nums.length){
               int a = nums[k];
               nums[k] = nums[R];
               nums[R] = a;
               k++;
               R++;
           }
       }

    }
}
