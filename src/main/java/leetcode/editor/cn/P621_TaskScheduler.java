package leetcode.editor.cn;

import java.util.Arrays;


//621-任务调度器
public class P621_TaskScheduler {

    public static void main(String[] args) {

        Solution solution = new P621_TaskScheduler().new Solution();
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int leastInterval(char[] tasks, int n) {
            int[] alpha = new int[26];

            for (int i = 0; i < tasks.length; i++) {
                int index = tasks[i] - 'A';
                alpha[index] = alpha[index] + 1;
            }
            //按由小到大排序
            Arrays.sort(alpha);
            //最大的值应该是 (做多出现次数-1)*(冷却时间+1)+与最多出现次数相同的任务数
            //-1的原因是因为最后一个没有冷却,冷却时间加一的原因的第一个任务耗费的时间
            //最后单独来加是因为最后一个不需要冷却;
            int res = (alpha[25] - 1) * (n + 1);
            int i = 25;
            //因为A占一个,所以从1开始
            int sameCnt = 1;
            while (i > 0 && alpha[i] == alpha[i - 1]) {
                sameCnt++;
                i--;
            }
            res += sameCnt;
            //特别地,如果冷却时间少或者任务多,这里面不能小于task的长度
            return Math.max(res, tasks.length);

        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}