package leetcode.editor.cn;

//363-矩形区域不超过 K 的最大数值和
public class P363_MaxSumOfRectangleNoLargerThanK {

    public static void main(String[] args) {

        Solution solution = new P363_MaxSumOfRectangleNoLargerThanK().new Solution();
        int[][] a = {{1, 0, 1}, {0, -2, 3}};
        int[][] a2 = {{2, 2, -1}};
        //        System.out.println(solution.maxSumSubmatrix(a, 3));
        System.out.println(solution.maxSumSubmatrix(a2, 0));
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int maxSumSubmatrix(int[][] matrix, int k) {
            if (matrix.length == 0) {
                return 0;
            }

            int m = matrix.length;
            int n = matrix[0].length;
            if (n == 0) {
                return 0;
            }
            int max = Integer.MIN_VALUE;
            for (int left = 0; left < n; left++) {
                int[] rowSum = new int[m];
                for (int right = left; right < n; right++) {
                    for (int height = 0; height < m; height++) {
                        rowSum[height] += matrix[height][right];
                    }
                    max = Math.max(max, nearlyK(rowSum, k));
                    if (max == k) {
                        return max;
                    }
                }

            }
            return max;

        }


        /**
         * 求数组内最接近K的最大值连续和,O(n*n)
         */
        private int nearlyK(int[] rowSum, int k) {
            int maxSum = Integer.MIN_VALUE;
            for (int i = 0; i < rowSum.length; i++) {
                int sum = 0;
                for (int j = i; j < rowSum.length; j++) {
                    sum += rowSum[j];
                    if (sum <= k) {
                        maxSum = Math.max(sum, maxSum);
                    }
                    if (maxSum == k) {
                        return k;
                    }

                }
            }
            return maxSum;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}