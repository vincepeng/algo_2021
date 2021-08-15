//给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target 的那 两个 整数，并返回它们的数组下标。 
//
// 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。 
//
// 你可以按任意顺序返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,7,11,15], target = 9
//输出：[0,1]
//解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,2,4], target = 6
//输出：[1,2]
// 
//
// 示例 3： 
//
// 
//输入：nums = [3,3], target = 6
//输出：[0,1]
// 
//
// 
//
// 提示： 
//
// 
// 2 <= nums.length <= 104 
// -109 <= nums[i] <= 109 
// -109 <= target <= 109 
// 只会存在一个有效答案 
// 
//
// 进阶：你可以想出一个时间复杂度小于 O(n2) 的算法吗？ 
// Related Topics 数组 哈希表 
// 👍 11758 👎 0


import java.util.HashMap;
import java.util.Map;


/***
 * 上次一些记得好像用缓存
 *[1,2,3,4,5]->6
 * 1+2 (k)->[1,2];
 *
 */

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
            //避免统一元素重复出现
            if (prevIndex != null) {
                return new int[]{prevIndex, i};
            }
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
