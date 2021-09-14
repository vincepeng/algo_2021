package leetcode.editor.cn;

//221-最大正方形
public class P221_MaximalSquare {

    public static void main(String[] args) {

        Solution solution = new P221_MaximalSquare().new Solution();
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int maximalSquare(char[][] matrix) {
            int m = matrix.length;
            int n = matrix[0].length;
            int[][] dp = new int[m + 1][n + 1];
            int max = 0;
            //dp为正方形的边
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (matrix[i][j] == '1') {
                        dp[i + 1][j + 1] = Math.min(Math.min(dp[i][j], dp[i][j + 1]), dp[i + 1][j]) + 1;
                        max = Math.max(max, dp[i + 1][j + 1]);
                    }
                }
            }
            return max * max;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}