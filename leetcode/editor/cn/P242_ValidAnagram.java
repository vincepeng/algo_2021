package leetcode.editor.cn;

import java.util.HashMap;


//242-有效的字母异位词
public class P242_ValidAnagram {

    public static void main(String[] args) {

        Solution solution = new P242_ValidAnagram().new Solution();
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public boolean isAnagram(String s, String t) {
            return useMapCnt(s, t);
        }


        /***
         * 将S转换为字符Map
         * @param s
         * @return
         */
        private HashMap<Character, Integer> toCharMap(String s) {
            char[] sourceChars = s.toCharArray();
            HashMap<Character, Integer> sourceCntMap = new HashMap<>();
            for (int i = 0; i < sourceChars.length; i++) {
                Integer cnt = sourceCntMap.get(sourceChars[i]);
                if (cnt == null) {
                    sourceCntMap.put(sourceChars[i], 0);
                }else {
                    sourceCntMap.put(sourceChars[i], ++cnt);
                }
            }
            return sourceCntMap;
        }


        /**
         * <b>方法一 :</b>使用字典统计
         * <p>时间复杂度:O(n)+O(n)+O(n)=O(n)</p>
         */
        private boolean useMapCnt(String s, String t) {
            if (s == null && t == null) {
                return true;
            }
            if (s == null || t == null) {
                return false;
            }


            HashMap<Character, Integer> sourceCntMap = toCharMap(s);
            HashMap<Character, Integer> targetMap = toCharMap(t);
            if (sourceCntMap.keySet().size() != targetMap.keySet().size()) {
                return false;
            }
            for (Character c : sourceCntMap.keySet()) {
                Integer sourceCnt = sourceCntMap.get(c);
                Integer targetCnt = targetMap.get(c);
                if (targetCnt == null || !sourceCnt.equals(targetCnt)) {
                    return false;
                }
            }
            return true;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}