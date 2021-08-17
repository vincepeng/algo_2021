package leetcode.editor.cn;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;


//347-前 K 个高频元素
public class PThree47_TopKFrequentElements {

    public static void main(String[] args) {

        Solution solution = new PThree47_TopKFrequentElements().new Solution();
        int[] src = new int[]{1, 1, 2, 3, 4, 4, 4, 5, 6, 7, 7, 7};
        int[] ints = solution.topKFrequent(src, 2);
        System.out.println(Arrays.toString(ints));
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * 方法1:通过hash进行统计tresHashMap,然后遍历结果大于值的k; 方法2:
         */
        public int[] topKFrequent(int[] nums, int k) {
            HashMap<Integer, Integer> cntMap = new HashMap<>();
            for (int num : nums) {
                Integer cnt = cntMap.get(num);
                if (cnt == null) {
                    cntMap.put(num, 1);
                }else {
                    cntMap.put(num, cnt + 1);
                }
            }

            Comparator<Map.Entry<Integer, Integer>> entryComparator = (o1, o2) -> -Integer.valueOf(o1.getValue()).compareTo(o2.getValue());
            int[] res = cntMap.entrySet().stream().sorted(entryComparator).mapToInt(Map.Entry::getKey).limit(k).toArray();
            return res;

        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}