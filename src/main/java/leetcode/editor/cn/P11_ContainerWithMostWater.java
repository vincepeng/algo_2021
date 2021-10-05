package leetcode.editor.cn;

//11-盛最多水的容器
public class P11_ContainerWithMostWater {

    public static void main(String[] args) {

        Solution solution = new P11_ContainerWithMostWater().new Solution();
        int[] a = {1, 1};
        System.out.println(solution.maxArea(a));
        int[] a2 = {4, 3, 2, 1, 4};
        System.out.println(solution.maxArea(a2));
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int maxArea(int[] height) {
            //暴力法:遍历(n*n),然后求最大值;
            int max = 0;
            int left = 0;
            int right = height.length - 1;

            while (left < right) {
                if (height[left] < height[right]) {
                    max = Math.max(max, (right - left) * height[left++]);
                }else {
                    max = Math.max(max, (right - left) * height[right--]);
                }
            }
            return max;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}