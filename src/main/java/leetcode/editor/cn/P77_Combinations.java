package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


//77-组合
public class P77_Combinations {

    public static void main(String[] args) {

        Solution solution = new P77_Combinations().new Solution();
        List<List<Integer>> combine = solution.combine(4, 2);
        System.out.println(combine);
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private List<List<Integer>> res = new ArrayList<>();


        //按道理c(n,k),徐顺序无关,如果与顺序相关则A(n,k)
        //复杂度:n2(nlogn)
        public List<List<Integer>> combine(int n, int k) {
            Map<Integer, List<Integer>> cache = new HashMap<>();
            boolean[] used = new boolean[n];

            LinkedList<Integer> path = new LinkedList<>();
            dfs(n, k, 0, used, path);

            return res;
        }


        private void dfs(int n, int k, int current, boolean[] used, LinkedList<Integer> path) {
            //退出
            if (path.size() == k) {
                res.add(new ArrayList<>(path));
                return;
            }
            //当前层处理,如果顺序相关则都从0开始,
            for (int i = current; i < n; i++) {
                //这个已经使用过了
                if (used[i] == false) {
                    path.add(i + 1);
                    used[i] = true;
                    //下一层
                    dfs(n, k, i + 1, used, path);
                    //清理数据,如果当前层不选择
                    used[i] = false;
                    path.removeLast();
                }

            }

        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}