package leetcode.editor.cn;

import java.util.Arrays;


//213-打家劫舍 II
public class P213_HouseRobberIi {

    public static void main(String[] args) {

        Solution solution = new P213_HouseRobberIi().new Solution();
        int[] a = {2, 3, 2};
        int[] a2 = {1, 2, 3, 1};
        System.out.println(solution.rob(a));
        System.out.println(solution.rob(a2));
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private int doRob(int[] nums) {
            if (nums.length < 2) {
                return nums[0];
            }
            int[] dp = new int[nums.length];
            dp[1] = Math.max(nums[0], nums[1]);
            dp[0] = nums[0];
            for (int i = 2; i < nums.length; i++) {
                dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
            }
            return dp[nums.length - 1];
        }


        public int rob(int[] nums) {
            if (nums.length == 1) {
                return nums[0];
            }
            if (nums.length == 2) {
                return Math.max(nums[0], nums[1]);
            }
            //抢了第一个,没有追后一个
            int[] hasFirst = Arrays.copyOfRange(nums, 0, nums.length - 1);
            int[] hasLatest = Arrays.copyOfRange(nums, 1, nums.length);
            int hasFirstResult = doRob(hasFirst);
            int hasLatestResult = doRob(hasLatest);
            return Math.max(hasFirstResult, hasLatestResult);

        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}