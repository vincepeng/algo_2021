package leetcode.editor.cn;

//541-反转字符串 II
public class P541_ReverseStringIi {

    public static void main(String[] args) {

        Solution solution = new P541_ReverseStringIi().new Solution();
        System.out.println(solution.reverseStr("abcdefg", 2));
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public String reverseStr(String s, int k) {
            //            return useString(s, k);
            return useString(s, k);

        }


        private void swap(char[] chars, int left, int right) {
            while (left < right) {
                char temp = chars[left];
                chars[left] = chars[right];
                chars[right] = temp;
                left++;
                right--;
            }
        }


        private String useString(String s, int k) {
            char[] chars = s.toCharArray();

            for (int left = 0; left < s.length(); left = left + 2 * k) {
                int right = left + k - 1;
                swap(chars, left, Math.min(right, s.length() - 1));

            }
            return new String(chars);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}