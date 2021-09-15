package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;


//22-括号生成
public class P22_GenerateParentheses {

    public static void main(String[] args) {

        Solution solution = new P22_GenerateParentheses().new Solution();
        solution.generateParenthesis(3);
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private void dfs(String str, int left, int right, int n, List<String> res) {
            if (left == n && right == n) {
                res.add(str);
                return;
            }
            if (left < right) {
                return;
            }

            if (left < n) {
                dfs(str + "(", left + 1, right, n, res);
            }
            if (right < n) {
                dfs(str + ")", left, right + 1, n, res);
            }

        }


        public List<String> generateParenthesis(int n) {
            //递归.(,),<n
            ArrayList<String> res = new ArrayList<>();
            dfs("", 0, 0, n, res);
            return res;
        }


        void useDP(int n) {
            //			dp[1]="()" ;dp[2]="()()(())"
            //			dp[n]=dp[n-1]+")" +dp[n-2]+"("+")"
            //状态方程
            //递归公式


        }

    }
    //leetcode submit region end(Prohibit modification and deletion)

}