package leetcode.editor.cn;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


//4-寻找两个正序数组的中位数
public class P4_MedianOfTwoSortedArrays {

    public static void main(String[] args) {

        Solution solution = new P4_MedianOfTwoSortedArrays().new Solution();
        int[] a1 = {1, 3};
        int[] a2 = {2};
        System.out.println(solution.findMedianSortedArrays(a1, a2));
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            //暴力法:将两个数组加起来,然后看如果是偶数,则去中位数的.nlogn.
            List<Integer> list1 = Arrays.stream(nums1).boxed().collect(Collectors.toList());
            List<Integer> list2 = Arrays.stream(nums2).boxed().collect(Collectors.toList());
            list1.addAll(list2);
            list1 = list1.stream().sorted().collect(Collectors.toList());
            boolean olden = list1.size() % 2 == 0;
            //0,1,2,3
            double result;
            if (olden) {//偶数
                result = ((double) list1.get(list1.size() / 2) + list1.get(list1.size() / 2 - 1)) / 2;
            }else {
                result = list1.get(list1.size() / 2);
            }

            return result;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}