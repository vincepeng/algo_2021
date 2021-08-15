//
// 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。 
//
// 
//
// 说明: 
//
// 为什么返回数值是整数，但输出的答案是数组呢? 
//
// 请注意，输入数组是以「引用」方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。 
//
// 你可以想象内部操作如下: 
//
// 
//// nums 是以“引用”方式传递的。也就是说，不对实参做任何拷贝
//int len = removeDuplicates(nums);
//
//// 在函数里修改输入数组对于调用者是可见的。
//// 根据你的函数返回的长度, 它会打印出数组中 该长度范围内 的所有元素。
//for (int i = 0; i < len; i++) {
//    print(nums[i]);
//}
// 
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,2]
//输出：2, nums = [1,2]
//解释：函数应该返回新的长度 2 ，并且原数组 nums 的前两个元素被修改为 1, 2 。不需要考虑数组中超出新长度后面的元素。
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,0,1,1,1,2,2,3,3,4]
//输出：5, nums = [0,1,2,3,4]
//解释：函数应该返回新的长度 5 ， 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4 。不需要考虑数组中超出新长度后面的元素。
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 3 * 104 
// -104 <= nums[i] <= 104 
// nums 已按升序排列 
// 
//
// 
// Related Topics 数组 双指针 
// 👍 2146 👎 0


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


//leetcode submit region begin(Prohibit modification and deletion)
public class Solution {


    public static void main(String[] args) {
        //        int[] ints = {1, 2, 3, 4, 5, 6, 7, 8};
        int[] ints = {3, 2, 4};
        int[] ints1 = new Solution().twoSum(ints, 6);
        System.out.printf(Arrays.toString(ints1));
    }


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
     * 第二周:看了下上周执行效率很差,可以提前终止的,没必要循环完成 同时也不用map了
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
        return getAndReturnWithCache(nums, target);
    }


    /**
     * 使用he的map,由于会遍历完所有,因此执行时间较长,稍微优化下,如果发现等于target直接返回
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
