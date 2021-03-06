package leetcode.editor.cn;

import java.util.Arrays;


//300-最长递增子序列
public class P300_LongestIncreasingSubsequence {

    public static void main(String[] args) {

        Solution solution = new P300_LongestIncreasingSubsequence().new Solution();
        int[] a3 = {0, 4, 5, 1, 2, 3};
        System.out.println(solution.lengthOfLIS(a3));

        int[] a4 = {1, 3, 6, 7, 9, 4, 10, 5, 6};
        System.out.println(solution.lengthOfLIS(a4));
        int[] a = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(solution.lengthOfLIS(a));
        int[] a2 = {0, 1, 0, 3, 2, 3};
        System.out.println(solution.lengthOfLIS(a2));
        int[] a6 = {7, 7, 7, 7, 7, 7, 7};
        System.out.println(solution.lengthOfLIS(a6));

    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int lengthOfLIS(int[] nums) {
            int[] dp = new int[nums.length];
            Arrays.fill(dp, 1);
            int max = 1;
            //最长o(N2)
            for (int i = 0; i < nums.length; i++) {
                for (int j = 0; j < i; j++) {
                    if (nums[i] > nums[j]) {
                        dp[i] = Math.max(dp[j] + 1, dp[i]);
                    }
                }
                max = Math.max(max, dp[i]);
            }
            return max;
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)

}