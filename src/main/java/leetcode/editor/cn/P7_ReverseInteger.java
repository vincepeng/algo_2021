package leetcode.editor.cn;

import java.util.LinkedList;


//7-整数反转
public class P7_ReverseInteger {

    public static void main(String[] args) {

        Solution solution = new P7_ReverseInteger().new Solution();
        System.out.println(solution.reverse(123));
        System.out.println(solution.reverse(-123));
        System.out.println(solution.reverse(1023));
        System.out.println(solution.reverse(-120));
        System.out.println(solution.reverse(0));

    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int reverse(int x) {
            //            return useQueue(x);
            return useTemp(x);
        }


        private int useQueue(int x) {
            if (x == 0) {
                return x;
            }

            LinkedList<Integer> queue = new LinkedList<>();
            //321
            while (x != 0) {
                int unit = x % 10;
                x = x / 10;
                queue.addLast(unit);
            }
            long result = 0;
            while (queue.size() > 0) {

                result = result * 10 + queue.poll();
            }
            if (result < Integer.MIN_VALUE || result > Integer.MAX_VALUE) {
                return 0;
            }
            return (int) result;
        }


        private int useTemp(int x) {
            int result = 0;
            int max = Integer.MAX_VALUE / 10;
            int min = Integer.MIN_VALUE / 10;
            while (x != 0) {
                int left = x % 10;
                x = x / 10;
                if (result > max || result < min) {
                    return 0;
                }

                result = result * 10 + left;

            }

            return result;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}