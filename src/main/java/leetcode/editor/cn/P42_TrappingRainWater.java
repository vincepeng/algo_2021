package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;


//42-接雨水
public class P42_TrappingRainWater {

    public static void main(String[] args) {

        Solution solution = new P42_TrappingRainWater().new Solution();
        int[] a = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(solution.trap(a));
        int[] a2 = {4, 2, 0, 3, 2, 5};
        System.out.println(solution.trap(a2));
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private int sum(int[] height, int left, int right) {
            int maxHeight = Math.min(height[left], height[right]);
            int area = 0;
            for (int i = left + 1; i < right; i++) {
                area += maxHeight > height[i] ? maxHeight - height[i] : 0;
            }
            return area;
        }


        public int trap(int[] height) {
            return useStack(height);

        }


        private int useStack(int[] height) {
            int current = 0;
            Deque<Integer> stack = new ArrayDeque<>();
            int area = 0;
            while (current < height.length) {
                //如果栈非空,则当前比他大的话,证明可能能存水;
                while (stack.size() > 0 && height[current] > height[stack.peek()]) {
                    Integer lowIndex = stack.pop();
                    //只有一个,最低值无法存水,因为需要结合前一个才能
                    if (stack.isEmpty()) {
                        break;
                    }
                    int distance = current - stack.peek() - 1;
                    //最矮的决定储水量
                    int currentHeight = Math.min(height[current], height[stack.peek()]) - height[lowIndex];
                    area += distance * currentHeight;
                }
                //不管怎样把当前放进去,如果后面是越来越小的话,会一直添加,类似于变深.如果是变大,会马上吧当前弹出的,类似于变高;
                stack.push(current++);

            }
            return area;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}