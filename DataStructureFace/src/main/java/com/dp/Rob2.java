package com.dp;

/**
 * @author cm
 * @create 2021/11/5-10:24 下午
 * 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都 围成一圈 ，这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。
 *
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，今晚能够偷窃到的最高金额。
 * 这个和第一个的差别就在于这道题的第一间和最后一件是相连的
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/house-robber-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Rob2 {

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        int rob = rob(nums);
        System.out.println(rob);
    }

    /**
     * 输入：nums = [1,2,3,1]
     * 输出：4
     * 解释：你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
     * 偷窃到的最高金额 = 1 + 3 = 4 。
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/house-robber-ii
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param nums 输入的参数
     * @return 返回能偷取的最大权益
     */
    public static int rob(int[] nums) {
        int n = nums.length;
        if(n == 1){
            return nums[0];
        }
        if (n == 2){
            return Math.max(nums[0],nums[1]);
        }
        return Math.max(robRange(nums,0,n-2),robRange(nums,1,n-1));
    }

    /**
     * 偷了第一家就不能偷最后一家，不偷第一家就能偷最后一家
     * @param nums
     * @param start
     * @param end
     * @return
     */
    public static int robRange(int[] nums, int start, int end) {
        int first = nums[start], second = Math.max(nums[start], nums[start + 1]);
        for (int i = start + 2; i <= end; i++) {
            int temp = second;
            second = Math.max(first + nums[i], second);
            first = temp;
        }
        return second;
    }
}
