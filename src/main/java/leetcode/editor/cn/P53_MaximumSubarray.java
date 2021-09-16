package leetcode.editor.cn;

//53-最大子序和
public class P53_MaximumSubarray {

    public static void main(String[] args) {

        Solution solution = new P53_MaximumSubarray().new Solution();
        int[] a = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        assert solution.maxSubArray(a) == 6 : "失败了";
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int maxSubArray(int[] nums) {

            return useDp(nums);
        }


        /**
         * 复杂度O(N)
         */
        private int useDp(int[] nums) {
            //动态规划
            //状态dp[n]
            //转移方程:dp[n]=dp[n-1]+nums[n]
            //int max=Math.max(dp[n],i)
            int next, pre = nums[0];
            int max = pre;
            for (int i = 1; i < nums.length; i++) {
                next = pre > 0 ? pre + nums[i] : nums[i];
                pre = next;
                max = Math.max(next, max);
            }
            return max;

        }


        /**
         * O(n)
         */
        private int useStrategy(int[] nums) {
            int max = nums[0];
            int sum = 0;


            for (int num : nums) {
                if (sum > 0) {
                    sum = sum + num;
                    //小于0,直接可以丢弃掉以前的;
                }else {
                    sum = num;
                }
                //这里记录过程中最大的值即可,可能遍历过程中会变小,但是记录了最大值;
                max = Math.max(sum, max);
            }
            return max;
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)

}