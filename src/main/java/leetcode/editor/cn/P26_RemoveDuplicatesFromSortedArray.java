package leetcode.editor.cn;

//26-删除有序数组中的重复项
public class P26_RemoveDuplicatesFromSortedArray {

    public static void main(String[] args) {

        Solution solution = new P26_RemoveDuplicatesFromSortedArray().new Solution();
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int removeDuplicates(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }

            int currentIndex = 0;
            for (int i = 0; i < nums.length; i++) {

                while (nums[currentIndex] == nums[i]) {
                    //最后一个数字了
                    if (i == nums.length - 1) {
                        return currentIndex + 1;
                    }else {
                        //往后移动1位;
                        ++i;
                    }
                }
                nums[++currentIndex] = nums[i];
            }
            return currentIndex + 1;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}