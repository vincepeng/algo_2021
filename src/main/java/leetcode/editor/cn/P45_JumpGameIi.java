package leetcode.editor.cn;

//45-跳跃游戏 II
public class P45_JumpGameIi {

    public static void main(String[] args) {

        Solution solution = new P45_JumpGameIi().new Solution();
        int[] a = {2, 3, 1, 1, 4};
        int[] a2 = {2, 3, 0, 1, 4};
        System.out.println(solution.jump(a));
        System.out.println(solution.jump(a2));

    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int jump(int[] nums) {
            //就是一个小迭代里面最佳,就可以使用贪心算法
            //这里的最佳就是在一个迭代范围内能跳刀的最远距离,这里使用currentMaxPosition表示;
            int currentMaxPosition = 0;
            int step = 0;
            int prevMaxPosition = 0;
            for (int i = 0; i < nums.length - 1; i++) {
                //当前位置能达到的最大距离,如果比最开始的大,则更新最大值
                //考虑到贪心就是跑得越远越好,越远步数越小;

                //如果当前位置可以跑得比记录还远,那么更新最大距离
                if (i + nums[i] > currentMaxPosition) {
                    currentMaxPosition = nums[i] + i;
                }
                //如果i已经到大上一次的最大值了,
                if (i == prevMaxPosition) {
                    //则步数需要加1了,算是多了一步了;
                    step++;
                    //然后更新下一步可以走到的位最远的位置;
                    //本质上利用的是能确保跑到最大的位置,只需要多一步即可
                    prevMaxPosition = currentMaxPosition;
                }

            }
            return step;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}