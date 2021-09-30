package leetcode.editor.cn;

import java.util.Arrays;


//300-最长递增子序列
public class P300_LongestIncreasingSubsequence {

    public static void main(String[] args) {

        Solution solution = new P300_LongestIncreasingSubsequence().new Solution();
        int[] a3 = {0, 4, 5, 1, 2, 3};
        System.out.println(solution.lengthOfLIS(a3));

        int[] a4 = {0, 3, 6, 1, 9};
        System.out.println(solution.lengthOfLIS(a4));
        int[] a = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(solution.lengthOfLIS(a));
        int[] a2 = {0, 1, 3};
        System.out.println(solution.lengthOfLIS(a2));
        int[] a6 = {0, 3, 2};
        System.out.println(solution.lengthOfLIS(a6));

    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int lengthOfLIS(int[] nums) {
            //(n*n)->dp[i]表示以i结尾的最长,最后再在整体中比较最大值即可;
            int[] dp = new int[nums.length];
            Arrays.fill(dp, 1);
            int max = 1;
            for (int i = 1; i < nums.length; i++) {
                for (int j = 0; j < i; j++) {
                    if (nums[i] > nums[j]) {
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                    }
                }
                max = Math.max(max, dp[i]);
            }
            return max;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}