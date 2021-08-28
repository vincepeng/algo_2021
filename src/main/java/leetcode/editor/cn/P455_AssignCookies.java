package leetcode.editor.cn;

import java.util.Arrays;


//455-分发饼干
public class P455_AssignCookies {

    public static void main(String[] args) {

        Solution solution = new P455_AssignCookies().new Solution();
        int[] g = {10, 9, 8, 7};
        int[] s = {5, 6, 7, 8};
        int contentChildren = solution.findContentChildren(g, s);
        System.out.println(contentChildren);
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int findContentChildren(int[] g, int[] s) {
            //排序O(nlog(n))
            Arrays.sort(g);
            Arrays.sort(s);
            int total = 0;
            for (int i = 0, j = 0; i < s.length && j < g.length; i++) {
                //匹配,则消费者增加一个,不管怎样,供应都会由小变大
                if (s[i] >= g[j]) {
                    j++;
                    total++;

                }

            }
            return total;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}