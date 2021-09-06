package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


//15-3Sum
public class P15_FourSum {

    public static void main(String[] args) {
        int[] sums = {1, 0, -1, 0, -2, 2};
        int[] sums2 = {2, 2, 2, 2};
        int[] sums3 = {-1, 0, 1, 2, -1, -4, -2, -3, 3, 0, 4};
        int[] sums4 = {-4, -1, -1, 0, 1, 2};
        Solution solution = new P15_FourSum().new Solution();
        List<List<Integer>> lists = solution.threeSum(sums2, 8);
        System.out.println(lists);
    }


    /**
     * 算法复杂度:使用while进行去重
     *
     * @param nums 数组 快速排序 O(nlog(n))+遍历O(n*n*n)=O(n3)
     */
    private List<List<Integer>> usePoint(int[] nums, int firstNumIndex, int target) {
        //指针方法
        if (nums == null || nums.length < 4) {
            return Collections.emptyList();
        }
        int leftThreeSum = target - nums[firstNumIndex];
        List<List<Integer>> result = new ArrayList<>();

        for (int i = firstNumIndex + 1; i < nums.length; i++) {

            int p = i + 1;
            int q = nums.length - 1;
            while (p < q) {
                int sum = nums[i] + nums[p] + nums[q];
                if (sum == leftThreeSum) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[firstNumIndex]);
                    temp.add(nums[i]);
                    temp.add(nums[p]);
                    temp.add(nums[q]);
                    result.add(temp);

                    //由于不能包含重复的数组,这里随便移动一个就行了,但是为了加快收敛各移动一位
                    //p移动只能保证一个情况,就是与原先一样大或者,比以前的更大;
                    //如果是一样大,只能q保证一样大的情况才能和为0,那时候一定是重复了,没意义
                    //如果是更大,那么q只能更小才能为0,因此q也要移动
                    //如果p和q都移动了,都与以前一样大,那么的出来的一定会重复,因此通过一个set来判断
                    p++;
                    q--;
                }
                //要往右边移动,由于是夹逼法,只能移动左边
                if (sum < leftThreeSum) {
                    p++;
                }
                //要往右边移动,由于是夹逼法,只能移动左边
                if (sum > leftThreeSum) {
                    q--;
                }
            }
        }
        return new ArrayList<>(result);
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * 四维数组
         */
        public List<List<Integer>> threeSum(int[] nums, int target) {
            Arrays.sort(nums);
            Set<List<Integer>> result = new HashSet<>();
            for (int i = 0; i < nums.length; i++) {
                List<List<Integer>> lists = usePoint(nums, i, target);
                result.addAll(lists);
            }
            return new ArrayList<>(result);
        }

    }

    //leetcode submit region end(Prohibit modification and deletion)

}