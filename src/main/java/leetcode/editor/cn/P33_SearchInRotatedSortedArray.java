package leetcode.editor.cn;

//33-搜索旋转排序数组
public class P33_SearchInRotatedSortedArray {

    public static void main(String[] args) {

        Solution solution = new P33_SearchInRotatedSortedArray().new Solution();
        int[] a = {4, 5, 6, 7, 0, 1, 2};
        int[] a2 = {3, 1};
        int[] a1 = {4, 5, 6, 7, 0, 1, 2};
        int[] a4 = {4, 5, 6, 7, 0, 1, 2};
        //        System.out.println(solution.search(a4, 2));
        System.out.println(solution.search(a2, 1));
        //        System.out.println(solution.search(a2, 4));
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int search(int[] nums, int target) {
            //本质还是一个二分查找
            //二分查找就是找对应找一半;
            int low = 0;
            int high = nums.length - 1;
            while (low <= high) {
                int mid = (low + high) / 2;
                if (nums[mid] == target) {
                    return mid;
                }
                if (nums[low] == target) {
                    return low;
                }
                if (nums[high] == target) {
                    return high;
                }

                //左边有序
                if (nums[low] < nums[mid]) {
                    //目标在左边,且小于中间的书,则搜索左边有序即可
                    if (nums[low] < target && nums[mid] > target) {
                        high = mid - 1;
                        //搜索右边
                    }else {
                        low = mid + 1;
                    }
                    //右边有序
                }else {
                    if (target < nums[high] && target > nums[mid]) {
                        low = mid + 1;
                    }else {
                        high = mid - 1;
                    }
                }
            }
            return -1;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}