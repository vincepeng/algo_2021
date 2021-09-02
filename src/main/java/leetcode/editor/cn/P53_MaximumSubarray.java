package leetcode.editor.cn;

//53-最大子序和
public class P53_MaximumSubarray {

    public static void main(String[] args) {

        Solution solution = new P53_MaximumSubarray().new Solution();
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int maxSubArray(int[] nums) {

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