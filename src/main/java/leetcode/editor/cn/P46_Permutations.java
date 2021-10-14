package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;


//46-全排列
public class P46_Permutations {

    public static void main(String[] args) {

        Solution solution = new P46_Permutations().new Solution();
        int[] a = {1, 2, 3};
        System.out.println(solution.permute(a));
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private List<List<Integer>> getPermute(int current, List<Integer> leftList) {
            //终止条件;只剩最后一个数字了;
            if (leftList.size() <= 0) {
                List<List<Integer>> ret = new LinkedList<>();
                LinkedList<Integer> currentList = new LinkedList<>();
                currentList.add(current);
                ret.add(currentList);
                return ret;
            }


            //下探一层(drill down)(1,2,3)->{1->(2,3),1->(3,2)}
            List<List<Integer>> mergeList = getPermute(leftList.get(0), leftList.subList(1, leftList.size()));
            //当前层逻辑
            int size = mergeList.size();
            List<List<Integer>> currentMergeList = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                List<Integer> tempList = mergeList.get(i);
                int tempSize = tempList.size();
                for (int j = 0; j <= tempSize; j++) {
                    ArrayList<Integer> currentList = new ArrayList<>(tempList);
                    currentList.add(j, current);
                    currentMergeList.add(currentList);
                }
            }
            //清理当前
            return currentMergeList;
        }


        public List<List<Integer>> permute(int[] nums) {
            //广度优先遍历,放入queue,哦.不需要判重
            //是否递归,拆分子任务的方式.先用递归吧;
            return useRecursive(nums);

        }


        private List<List<Integer>> useRecursive(int[] nums) {
            if (nums == null || nums.length == 0) {
                return Collections.emptyList();
            }
            List<Integer> leftList = new LinkedList<>();
            for (int i = 1; i < nums.length; i++) {
                leftList.add(nums[i]);
            }
            List<List<Integer>> retList = getPermute(nums[0], leftList);
            return retList;

        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}