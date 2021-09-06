package leetcode.editor.cn;

//64-最小路径和
public class P64_MinimumPathSum {

    public static void main(String[] args) {

        Solution solution = new P64_MinimumPathSum().new Solution();
        int[][] a = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        int[][] a2 = {{1, 2, 3}, {4, 5, 6}};
        System.out.println(solution.minPathSum(a));
        System.out.println(solution.minPathSum(a2));
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * 复杂度O(M*N).这个题主要问题
         */
        public int minPathSum(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            int[][] dp = new int[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (i == 0 && j == 0) {
                        dp[i][j] = grid[i][j];
                    }else if (i == 0) {
                        dp[i][j] = grid[i][j] + dp[i][j - 1];
                    }else if (j == 0) {
                        dp[i][j] = grid[i][j] + dp[i - 1][j];
                    }else {
                        dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
                    }
                }
            }
            return dp[m - 1][n - 1];
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}