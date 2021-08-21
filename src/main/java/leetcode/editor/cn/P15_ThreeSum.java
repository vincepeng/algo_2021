package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


//15-3Sum
public class P15_ThreeSum {

    public static void main(String[] args) {
        int[] sums = {-1, 0, 1, 2, -1, -4};
        int[] sums2 = {-2, 0, 0, 2, 2};
        int[] sums3 = {-1, 0, 1, 2, -1, -4, -2, -3, 3, 0, 4};
        int[] sums4 = {-4, -1, -1, 0, 1, 2};
        Solution solution = new P15_ThreeSum().new Solution();
        List<List<Integer>> lists = solution.threeSum(sums4);
        System.out.println(lists);
    }


    /**
     * 算法复杂度:使用while进行去重
     *
     * @param nums 数组 快速排序 log(n)+遍历和假币O(N2)
     */
    private List<List<Integer>> usePoint1(int[] nums) {
        //指针方法
        if (nums == null || nums.length < 3) {
            return Collections.emptyList();
        }

        Set<List<Integer>> result = new HashSet<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int p = i + 1;
            int q = nums.length - 1;
            while (p < q) {
                int sum = nums[i] + nums[p] + nums[q];
                if (sum == 0) {
                    List<Integer> temp = new ArrayList<>();
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
                if (sum < 0) {
                    p++;
                }
                //要往右边移动,由于是夹逼法,只能移动左边
                if (sum > 0) {
                    q--;
                }
            }
        }
        return result.stream().collect(Collectors.toList());
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {


        public List<List<Integer>> threeSum(int[] nums) {
            return usePoint2(nums);
        }


        /**
         * 算法复杂度:
         *
         * @param nums 数组 快速排序 log(n)+遍历和假币O(N2)
         */
        private List<List<Integer>> usePoint2(int[] nums) {
            //指针方法
            if (nums == null || nums.length < 3) {
                return Collections.emptyList();
            }

            List<List<Integer>> result = new ArrayList<>();
            Arrays.sort(nums);
            System.err.println(Arrays.toString(nums));
            for (int i = 0; i < nums.length - 1; i++) {
                //针对i也需要去重
                if (i > 0 && nums[i] == nums[i - 1]) {
                    continue;
                }

                int p = i + 1;
                int q = nums.length - 1;
                while (p < q) {

                    if (nums[i] + nums[p] + nums[q] == 0) {
                        result.add(Arrays.asList(nums[i], nums[p], nums[q]));
                        //如果下一位和当前重复,那么一定需要继续移动,直到不一样为止;
                        while (p < q && nums[p + 1] == nums[p]) {
                            p++;
                        }
                        while (p < q && nums[q - 1] == nums[q]) {
                            q--;
                        }
                        //移动到不同的以为;
                        p++;
                        q--;
                    }
                    //要往右边移动,由于是夹逼法,只能移动左边,由于上面有移动,所以重新判断是否为0
                    if (p < q && nums[i] + nums[p] + nums[q] < 0) {
                        p++;
                    }
                    //要往右边移动,由于是夹逼法,只能移动左边,由于上面有移动,所以重新判断是否为0
                    if (p < q && nums[i] + nums[p] + nums[q] > 0) {
                        q--;
                    }
                }
            }
            return result;
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)

}