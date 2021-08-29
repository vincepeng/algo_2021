package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;


//169-多数元素
public class P169_MajorityElement {

    public static void main(String[] args) {

        Solution solution = new P169_MajorityElement().new Solution();
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int majorityElement(int[] nums) {
            return useMap(nums);
        }


        /**
         * O(N)--O(N)
         */
        private int useMap(int[] nums) {
            Map<Integer, Integer> cntMap = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                Integer cnt = cntMap.getOrDefault(nums[i], 0);
                cntMap.put(nums[i], ++cnt);
                if (cnt >= nums.length / 2) {
                    return nums[i];
                }
            }
            return -1;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}