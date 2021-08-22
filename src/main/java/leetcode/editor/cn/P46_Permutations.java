package leetcode.editor.cn;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;


//46-Permutations
public class P46_Permutations {

    public static void main(String[] args) {

        Solution solution = new P46_Permutations().new Solution();


        List<List<Integer>> r1 = solution.getSubPermute(Arrays.asList(1));
        System.out.println(r1);
        List<List<Integer>> r2 = solution.getSubPermute(Arrays.asList(1, 2));
        System.out.println(r2);
        List<List<Integer>> r3 = solution.getSubPermute(Arrays.asList(1, 2, 3));
        System.out.println(r3);

    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private List<List<Integer>> getSubPermute(List<Integer> leftNums) {
            if (leftNums.size() == 0) {
                return Collections.emptyList();
            }
            //终止条件
            if (leftNums.size() == 1) {
                LinkedList<Integer> currentNums = new LinkedList<>(leftNums);
                List<List<Integer>> currentLevel = new LinkedList<>();
                currentLevel.add(currentNums);
                return currentLevel;
            }
            //下层迭代
            List<List<Integer>> currentSubList = getSubPermute(leftNums.subList(0, leftNums.size() - 1));
            //本层处理
            Integer lastNum = leftNums.get(leftNums.size() - 1);
            List<List<Integer>> currentLevel = new LinkedList<>();
            currentSubList.forEach(list -> {
                for (int i = 0; i <= list.size(); i++) {
                    LinkedList<Integer> currentNums = new LinkedList<>(list);
                    currentNums.add(i, lastNum);
                    currentLevel.add(currentNums);
                }
            });
            return currentLevel;
        }


        public List<List<Integer>> permute(int[] nums) {
            if (nums == null) {
                return Collections.emptyList();
            }
            return getSubPermute(Arrays.stream(nums).boxed().collect(Collectors.toList()));
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)

}