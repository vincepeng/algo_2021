package leetcode.editor.cn;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;


//264-Ugly Number II
public class PTwo64_UglyNumberIi {

    public static void main(String[] args) {

        Solution solution = new PTwo64_UglyNumberIi().new Solution();
        System.out.println(solution.nthUglyNumber(10));
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int nthUglyNumber(int n) {
            Set<Long> res = new HashSet<>();
            int[] factors = new int[]{2, 3, 5};
            PriorityQueue<Long> queue = new PriorityQueue<>();
            long cur = 1;
            long ugly = 1;
            queue.offer(ugly);
            res.add(1L);
            for (int i = 0; i < n; i++) {
                cur = queue.poll();
                for (int f : factors) {
                    ugly = cur * f;
                    if (res.add(ugly)) {
                        queue.offer(ugly);
                    }
                    //                    System.out.println(ugly);
                }
            }
            return (int) cur;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}