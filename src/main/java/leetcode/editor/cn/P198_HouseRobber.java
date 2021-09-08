package leetcode.editor.cn;

//198-打家劫舍
public class P198_HouseRobber {

    public static void main(String[] args) {

        Solution solution = new P198_HouseRobber().new Solution();
        int[] a = {1, 2, 3, 1};
        int[] a2 = {2, 7, 9, 3, 1};
        System.out.println(solution.rob(a));
        System.out.println(solution.rob(a2));
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int rob(int[] nums) {
            if (nums.length == 1) {
                return nums[0];
            }
            int[] dp = new int[nums.length];
            dp[0] = nums[0];
            dp[1] = Math.max(nums[0], nums[1]);
            for (int i = 2; i < nums.length; i++) {
                dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
            }
            return dp[nums.length - 1];
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)

}