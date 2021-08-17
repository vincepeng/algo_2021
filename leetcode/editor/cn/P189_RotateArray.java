//给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。 
//
// 
//
// 进阶： 
//
// 
// 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。 
// 你可以使用空间复杂度为 O(1) 的 原地 算法解决这个问题吗？ 
// 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [1,2,3,4,5,6,7], k = 3
//输出: [5,6,7,1,2,3,4]
//解释:
//向右旋转 1 步: [7,1,2,3,4,5,6]
//向右旋转 2 步: [6,7,1,2,3,4,5]
//向右旋转 3 步: [5,6,7,1,2,3,4]
// 
//
// 示例 2: 
//
// 
//输入：nums = [-1,-100,3,99], k = 2
//输出：[3,99,-1,-100]
//解释: 
//向右旋转 1 步: [99,-1,-100,3]
//向右旋转 2 步: [3,99,-1,-100] 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 2 * 104 
// -231 <= nums[i] <= 231 - 1 
// 0 <= k <= 105 
// 
//
// 
// 
// Related Topics 数组 数学 双指针 
// 👍 1068 👎 0


package leetcode.editor.cn;

//旋转数组


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class P189_RotateArray {

    public static void main(String[] args) {
        //测试代码
        Solution solution = new P189_RotateArray().new Solution();
        int[] ints = {1, 2, 3, 4, 5, 6, 7};
        solution.rotate(ints, 3);
        System.out.println(Arrays.toString(ints));
        int[] ints2 = {1, 2};
        solution.rotate(ints2, 1);
        //[1,2]->[2,1]->1,2->2,1
        System.out.println(Arrays.toString(ints2));

        int[] ints3 = {-1, -100, 3, 99};
        solution.rotate(ints3, 2);
        //[1,2]->[2,1]->1,2->2,1
        System.out.println(Arrays.toString(ints3));

    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {


        public void rotate(int[] nums, int k) {

            swapTo(nums, k);

        }


        //[1,2,3,4,5]
        private void swap(int[] nums, int start, int end) {
            int temp;
            while (start < end) {
                temp = nums[start];
                nums[start] = nums[end];
                nums[end] = temp;
                start++;
                end--;
            }

        }


        private void swapTo(int[] nums, int k) {
            if (k > nums.length) {
                k = k % nums.length;
            }

            swap(nums, 0, nums.length - 1);
            //使用k进行分割
            swap(nums, 0, k - 1);
            swap(nums, k, nums.length - 1);
        }


        private void useSublist(int[] nums, int k) {
            if (k > nums.length) {
                k = k % nums.length;
            }

            ArrayList<Integer> srcList = new ArrayList<>();
            for (int num : nums) {
                srcList.add(num);
            }
            List<Integer> leftList = srcList.subList(0, srcList.size() - k);
            List<Integer> rightList = srcList.subList(srcList.size() - k, srcList.size());
            rightList.addAll(leftList);
            for (int i = 0; i < nums.length; i++) {
                nums[i] = rightList.get(i);
            }
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)

}