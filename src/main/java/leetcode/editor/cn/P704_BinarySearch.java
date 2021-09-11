package leetcode.editor.cn;

//704-二分查找
public class P704_BinarySearch {

    public static void main(String[] args) {

        Solution solution = new P704_BinarySearch().new Solution();
        int[] a = {-1, 0, 3, 5, 9, 12};
        System.out.println(solution.search(a, 9));
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int search(int[] nums, int target) {
            int low = 0;
            int high = nums.length - 1;
            while (low <= high) {
                int mid = (low + high) / 2;
                if (nums[mid] < target) {
                    low = mid + 1;
                }else if (nums[mid] == target) {
                    return mid;
                }else if (nums[mid] > target) {
                    high = mid - 1;
                }
            }

            return -1;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}