package leetcode.editor.cn;

//14-最长公共前缀
public class P14_LongestCommonPrefix {

    public static void main(String[] args) {

        Solution solution = new P14_LongestCommonPrefix().new Solution();
        String[] sb = {"abc", "acd"};
        System.out.println(solution.longestCommonPrefix(sb));
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public String longestCommonPrefix(String[] strs) {
            if (strs == null || strs.length == 0) {
                return "";
            }
            StringBuilder longPreStr = new StringBuilder(strs[0]);
            for (int i = 1; i < strs.length; i++) {
                String str = strs[i];
                int index = 0;
                while (index < str.length() && index < longPreStr.length()) {
                    if (str.charAt(index) == longPreStr.charAt(index)) {
                        index++;
                    }else {
                        break;
                    }
                }
                longPreStr.delete(index, longPreStr.length());
                if (longPreStr.length() == 0) {
                    return "";
                }
            }
            return longPreStr.toString();
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}