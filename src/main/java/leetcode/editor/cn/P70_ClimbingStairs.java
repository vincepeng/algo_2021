package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;


//70-爬楼梯
public class P70_ClimbingStairs {

    public static void main(String[] args) {

        System.out.println(new P70_ClimbingStairs().new Solution().climbStairs(2));
        System.out.println(new P70_ClimbingStairs().new Solution().climbStairs(3));
        System.out.println(new P70_ClimbingStairs().new Solution().climbStairs(45));
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private Map<Integer, Integer> solutions = new HashMap();


        public int climbStairs(int n) {

            return useMath(n);

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


        private int doClimbStairsWithDp(int n) {
            int[] dp = new int[n + 1];
            dp[0] = 1;
            dp[1] = 1;
            for (int i = 2; i <= n; i++) {
                dp[i] = dp[i - 1] + dp[i - 2];
            }
            return dp[n];
        }


        private int doClimbStairsWithDpTemp(int n) {
            int p = 0, q = 1, r = 1;

            for (int i = 2; i <= n; i++) {
                p = q;
                q = r;
                r = p + q;
            }
            return r;
        }


        private int useMath(int n) {
            double sqrt5 = Math.sqrt(5);
            double fibn = Math.pow((1 + sqrt5) / 2, n + 1) - Math.pow((1 - sqrt5) / 2, n + 1);
            return (int) Math.round(fibn / sqrt5);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}