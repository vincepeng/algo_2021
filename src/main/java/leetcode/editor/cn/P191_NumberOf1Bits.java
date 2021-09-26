package leetcode.editor.cn;

//191-位1的个数
public class P191_NumberOf1Bits {

    public static void main(String[] args) {

        Solution solution = new P191_NumberOf1Bits().new Solution();
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    public class Solution {

        // you need to treat n as an unsigned value
        public int hammingWeight(int n) {
            return useShift(n);
            //            return useAnd(n);
        }


        private int useAnd(int n) {
            int cnt = 0;
            while (n != 0) {
                cnt++;
                n &= (n - 1);
            }
            return cnt;
        }


        private int useShift(int n) {
            int result = 0;
            for (int i = 0; i < 32; i++) {
                if (((n >>> i) & 1) == 1) {
                    result++;
                }
            }
            return result;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}