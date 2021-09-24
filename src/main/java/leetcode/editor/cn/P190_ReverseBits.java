package leetcode.editor.cn;

//190-颠倒二进制位
public class P190_ReverseBits {

    public static void main(String[] args) {

        Solution solution = new P190_ReverseBits().new Solution();
        //101->
        printResult(solution.reverseBits(5));
    }


    private static void printResult(int i) {
        System.out.println(Integer.toBinaryString(i));
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    public class Solution {

        // you need treat n as an unsigned value
        //110101
        public int reverseBits(int n) {
            return useShift(n);
            //            return useArray(n);
        }


        private int useArray(int n) {
            return Integer.reverse(n);
        }


        private int useShift(int n) {
            int result = 0;
            for (int i = 1; i <= 32; i++) {
                //向左移动i位,然后将后面的抹掉
                if (i <= 16) {
                    result += n << (32 - 2 * i + 1) & (1 << (32 - i));
                }else {
                    result += (n >>> (2 * (i - 16) - 1)) & (1 << (32 - i));
                }

            }
            return result;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}