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
            if (n == 0 || n == 1 || n == 2) {
                return n;
            }
            Integer cnt = solutions.get(n);
            if (cnt == null) {
                int n_cnt = doClimbStairs(n - 2) + doClimbStairs(n - 1);
                solutions.put(n, n_cnt);
                return n_cnt;
            }else {
                return cnt;
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}