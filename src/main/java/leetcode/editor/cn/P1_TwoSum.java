package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;


//1-两数之和
public class P1_TwoSum {

    public static void main(String[] args) {

        Solution solution = new P1_TwoSum().new Solution();
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {


        /**
         * 第二周:看了下上周执行效率很差,可以提前终止的,没必要循环完成 同时也不用map了
         */
        private int[] getAndReturn(int[] nums, int target) {
            for (int i = 0; i < nums.length - 1; i++) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[i] + nums[j] == target) {
                        return new int[]{i, j};
                    }

                }
            }
            return null;
        }


        /**
         * <p>第二周2:按照升纬思考,第二层的遍历可以通过缓存优化,在第一次遍历时就留下信息,通过缓存直接终止</p>
         */
        private int[] getAndReturnWithCache(int[] nums, int target) {
            Map<Integer, Integer> map = new HashMap<>();
            int current, left;
            for (int i = 0; i < nums.length; i++) {
                current = nums[i];
                left = target - current;
                Integer prevIndex = map.get(current);

                if (prevIndex != null) {
                    return new int[]{prevIndex, i};
                }
                //避免统一元素重复出现,最后放置
                map.put(left, i);
            }
            return null;
        }


        public int[] twoSum(int[] nums, int target) {
            //第一周:使用map
            //        return useMapOfSum(nums, target);
            //第二周1.:直接判断并终止O(n2)
            //        return getAndReturn(nums, target);
            //第二周2.:第二步遍历缓存起来
            return getAndReturnWithCache(nums, target);
        }


        /**
         * 使用he的map,由于会遍历完所有,因此执行时间较长,稍微优化下,如果发现等于target直接返回
         * <p>时间复杂度:O(n2)</p>
         */
        private int[] useMapOfSum(int[] nums, int target) {
            Map<Integer, int[]> records = new HashMap<>();

            for (int i = 0; i < nums.length - 1; i++) {
                for (int j = i + 1; j < nums.length; j++) {
                    int sum = nums[i] + nums[j];
                    //去重元素
                    int[] indexes = {i, j};
                    records.put(sum, indexes);
                }
            }
            int[] integers = records.get(target);
            return integers;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}