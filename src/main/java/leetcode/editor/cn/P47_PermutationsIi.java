package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


//47-全排列 II
public class P47_PermutationsIi {

    public static void main(String[] args) {

        Solution solution = new P47_PermutationsIi().new Solution();
        int[] a = {1, 2, 1};
        System.out.println(solution.permuteUnique(a));
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        List<List<Integer>> res = new LinkedList<>();


        private void doPermuteUnique(int[] nums, boolean[] used, LinkedList<Integer> path) {
            if (path.size() == nums.length) {
                res.add(new ArrayList<>(path));
                return;
            }
            for (int i = 0; i < nums.length; i++) {
                if (used[i] == false) {
                    path.add(nums[i]);
                    used[i] = true;
                    doPermuteUnique(nums, used, path);
                    path.removeLast();
                    used[i] = false;
                }

            }
        }


        public List<List<Integer>> permuteUnique(int[] nums) {


            LinkedList<Integer> path = new LinkedList<>();
            boolean[] used = new boolean[nums.length];
            doPermuteUnique(nums, used, path);
            Set<List<Integer>> resSet = new HashSet<>(res);
            return resSet.stream().collect(Collectors.toList());
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}