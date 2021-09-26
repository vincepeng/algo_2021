package leetcode.editor.cn;

//231-2 的幂
public class P231_PowerOfTwo {

    public static void main(String[] args) {

        Solution solution = new P231_PowerOfTwo().new Solution();
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public boolean isPowerOfTwo(int n) {
            //由于2的幂只能有1个1.因此移除最后一个1,一定为0 ;
            if (n <= 0) {
                return false;
            }
            return (n & (n - 1)) == 0;

        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}