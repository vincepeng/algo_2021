package leetcode.editor.cn;

//74-搜索二维矩阵
public class P74_SearchA2dMatrix {

    public static void main(String[] args) {

        Solution solution = new P74_SearchA2dMatrix().new Solution();
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public boolean searchMatrix(int[][] matrix, int target) {
            int m = matrix.length, n = matrix[0].length;
            int low = 0, high = m * n - 1;
            while (low <= high) {
                int mid = (high - low) / 2 + low;
                int x = matrix[mid / n][mid % n];
                if (x < target) {
                    low = mid + 1;
                }else if (x > target) {
                    high = mid - 1;
                }else {
                    return true;
                }
            }
            return false;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}