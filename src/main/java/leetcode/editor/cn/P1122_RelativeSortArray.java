package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


//1122-数组的相对排序
public class P1122_RelativeSortArray {

    public static void main(String[] args) {
        int[] a1 = {2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19};
        int[] a2 = {2, 1, 4, 3, 9, 6};
        Solution solution = new P1122_RelativeSortArray().new Solution();
        System.out.println(Arrays.toString(solution.relativeSortArray(a1, a2)));
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int[] relativeSortArray(int[] arr1, int[] arr2) {
            //暴力法:m*n;List(add)
            //sortSet;(m)+n+(m-n)log(m-n)+o(m);
            //1.转化为map
            HashMap<Integer, List<Integer>> temp = new HashMap<>();
            for (int a : arr1) {
                List<Integer> integers = temp.get(a);
                if (integers == null) {
                    integers = new ArrayList<>();
                    temp.put(a, integers);
                }
                integers.add(a);
            }
            //2.查找已有的
            ArrayList<Integer> result = new ArrayList<>();
            for (int a : arr2) {
                //由于一定存在,所以这里直接加进去
                result.addAll(temp.remove(a));
            }
            //3.处理剩下的排序;
            //最后排序更节省性能;
            temp.entrySet().stream().sorted(Comparator.comparing(Map.Entry::getKey)).forEach(entry -> {
                result.addAll(entry.getValue());
            });
            int[] resultArray = new int[result.size()];
            for (int i = 0; i < result.size(); i++) {
                resultArray[i] = result.get(i);
            }

            return resultArray;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}