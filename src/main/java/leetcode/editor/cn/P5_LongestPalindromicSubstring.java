package leetcode.editor.cn;

//5-最长回文子串
public class P5_LongestPalindromicSubstring {

    public static void main(String[] args) {

        Solution solution = new P5_LongestPalindromicSubstring().new Solution();
        System.out.println(solution.longestPalindrome("ac"));
        System.out.println(solution.longestPalindrome("abba"));
        System.out.println(solution.longestPalindrome("a"));
        System.out.println(solution.longestPalindrome("babad"));
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public String longestPalindrome(String s) {
            if (s == null || s.length() < 2) {
                return s;
            }

            int len = s.length();
            boolean[][] dp = new boolean[len][len];
            //从i->j是否回文(true
            //递归情况为dp[i][j]=s[i]==s[j]&&dp[i-1][j-1]||奇数
            int maxLen = 0;
            int start = 0;
            for (int left = len - 1; left >= 0; left--) {
                for (int right = left; right < len; right++) {
                    //aba
                    //abba(前面一个为奇数,后面一个为偶数)
                    dp[left][right] = s.charAt(left) == s.charAt(right) && (right - left < 2 || dp[left + 1][right - 1]);
                    if (dp[left][right] && (right - left + 1 > maxLen)) {
                        maxLen = right - left + 1;
                        start = left;
                    }
                }
            }
            return s.substring(start, start + maxLen);
        }


        //O(N3)
        public String longestPalindrome2(String s) {
            String maxString = "";
            for (int i = 0; i < s.length(); i++) {
                for (int j = s.length(); j >= i; j--) {
                    String tempStr = "";
                    String substring = s.substring(i, j);
                    if (substring.length() <= maxString.length()) {
                        break;
                    }
                    //奇数
                    if (substring.length() % 2 != 0) {
                        int left = substring.length() / 2 - 1;
                        int right = left + 2;
                        tempStr = "" + substring.charAt(substring.length() / 2);
                        while (left >= 0 && right < substring.length() && substring.charAt(left) == substring.charAt(right)) {
                            tempStr = substring.charAt(left) + tempStr + substring.charAt(left);
                            left--;
                            right++;
                        }
                    }else {
                        int left = substring.length() / 2 - 1;
                        int right = substring.length() / 2;

                        while (left >= 0 && right < substring.length() && substring.charAt(left) == substring.charAt(right)) {
                            tempStr = substring.charAt(left) + tempStr + substring.charAt(left);
                            left--;
                            right++;
                        }
                    }


                    maxString = maxString.length() < tempStr.length() ? tempStr : maxString;
                }
            }
            return maxString;
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)

}