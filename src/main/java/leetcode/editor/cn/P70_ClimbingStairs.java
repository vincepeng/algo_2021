package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;


//70-爬楼梯
public class P70_ClimbingStairs {

    public static void main(String[] args) {

        System.out.println(new P70_ClimbingStairs().new Solution().climbStairs(2));
        System.out.println(new P70_ClimbingStairs().new Solution().climbStairs(45));
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private Map<Integer, Integer> solutions = new HashMap();


        public int climbStairs(int n) {

            return doClimbStairs(n);

        }


        private int doClimbStairs(int n) {
            //终止;
            if (n == 0) {
                return 0;
            }
            if (n == 1) {
                return 1;
            }
            if (n == 2) {
                return 2;
            }
            Integer cnt = solutions.get(n);
            if (cnt == null) {
                int n_2_cnt = doClimbStairs(n - 2);
                int n_1_cnt = doClimbStairs(n - 1);
                int i = n_2_cnt + n_1_cnt;
                solutions.put(n, i);
                return i;
            }else {
                return cnt;
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}