package leetcode.editor.cn;

//367-有效的完全平方数
public class P367_ValidPerfectSquare {

    public static void main(String[] args) {

        Solution solution = new P367_ValidPerfectSquare().new Solution();
        System.out.println(solution.isPerfectSquare(16));
        System.out.println(solution.isPerfectSquare(13));
        System.out.println(solution.isPerfectSquare(2147483647));
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public boolean isPerfectSquare(int num) {
            if (num == 1)
                return true;
            long currentResult;
            int start = 1;
            int end = num;

            while (start <= end) {
                int mid = start + (end - start) / 2;
                currentResult = (long) mid * mid;
                if (currentResult == num) {
                    return true;
                    //太小,往右边移动
                }else if (currentResult < num) {
                    start = mid + 1;
                    //太大,往左边移动
                }else {
                    end = mid - 1;
                }
            }
            return false;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}