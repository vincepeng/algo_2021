package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


//718-最长重复子数组
public class P718_MaximumLengthOfRepeatedSubarray {

    public static void main(String[] args) {

        Solution solution = new P718_MaximumLengthOfRepeatedSubarray().new Solution();
        int[] a = {1, 2, 3, 2, 1};
        int[] b = {3, 2, 1, 4, 7};

        System.out.println(solution.findLength(a, b));
        int[] a2 = {0, 0, 0, 0, 0};
        int[] b2 = {0, 0, 0, 0, 0};
        System.out.println(solution.findLength(a2, b2));
    }
    //优先遍历那个?应该是短的最合适;
    //然后找到所有子数组(感觉也不用找完),可以变对比边找;
    //找到结果返回;
    //复杂度:n!*m的复杂度;


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int findLength(int[] nums1, int[] nums2) {

            int[][] dp = new int[nums1.length + 1][nums2.length + 1];
            int maxResult = 0;
            for (int i = 1; i <= nums1.length; i++) {
                for (int j = 1; j <= nums2.length; j++) {
                    if (nums1[i - 1] == nums2[j - 1]) {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    }
                    maxResult = Math.max(dp[i][j], maxResult);

                }
            }
            return maxResult;
        }


        public int findLength2(int[] nums1, int[] nums2) {
            int[] shortArray, lengthArray;
            if (nums1.length > nums2.length) {
                shortArray = nums2;
                lengthArray = nums1;
            }else {
                shortArray = nums1;
                lengthArray = nums2;
            }
            Map<Integer, List<Integer>> valueIndexMap = new HashMap<>();
            for (int i = 0; i < lengthArray.length; i++) {
                List<Integer> indexList = valueIndexMap.get(lengthArray[i]);
                if (indexList == null) {
                    indexList = new ArrayList<>();
                    valueIndexMap.put(lengthArray[i], indexList);
                }
                indexList.add(i);
            }

            int maxResult = 0;
            for (int start = 0; start < shortArray.length; start++) {
                if (shortArray.length - start <= maxResult) {
                    break;
                }

                //从最长的开始.因此第一个
                for (int i = 0; i <= start; i++) {
                    List<Integer> integers = valueIndexMap.get(shortArray[i]);
                    //没有这个数字;
                    if (integers == null) {
                        continue;
                    }
                    for (int lenIndex : integers) {
                        int tempResult = 1;
                        int startShort = i + 1;
                        int startLen = lenIndex + 1;
                        while (startShort < shortArray.length && startLen < lengthArray.length) {
                            if (shortArray[startShort] != lengthArray[startLen]) {
                                break;
                            }else {
                                //向右移动
                                tempResult++;
                                startShort++;
                                startLen++;
                            }
                        }
                        maxResult = Math.max(tempResult, maxResult);
                    }

                }

            }
            return maxResult;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}