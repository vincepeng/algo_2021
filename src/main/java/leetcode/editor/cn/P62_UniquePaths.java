package leetcode.editor.cn;

import java.util.Arrays;


//62-不同路径
public class P62_UniquePaths {

    public static void main(String[] args) {

        Solution solution = new P62_UniquePaths().new Solution();
        System.out.println(solution.uniquePaths(2, 2));
        System.out.println(solution.uniquePaths(3, 2));
        System.out.println(solution.uniquePaths(3, 3));
        System.out.println(solution.uniquePaths(3, 7));
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int uniquePaths(int m, int n) {
            //                        return useDpTwoDimensionArray(m, n);
            return useDpArray(m, n);

        }


        private int useDpArray(int m, int n) {
            int[] dp = new int[n + 1];
            //            Arrays.fill(dp, 1);
            Arrays.fill(dp, 1);
            //将第一排和第一列的值都初始化为1,但是
            //由于第一列和第一排都初始化了,因此从第二排,第二列开始算起来就行了
            for (int i = 2; i <= m; i++) {
                for (int j = 2; j <= n; j++) {
                    //等于上一行+加上当前行比自己笑一个的;
                    dp[j] = dp[j - 1] + dp[j];
                }
            }
            return dp[n];
        }


        private int useDpTwoDimensionArray(int m, int n) {
            int[][] dp = new int[m + 1][n + 1];
            dp[0][1] = 1;
            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
            return dp[m][n];
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}