package leetcode.editor.cn;

//91-解码方法
public class P91_DecodeWays {

    public static void main(String[] args) {

        Solution solution = new P91_DecodeWays().new Solution();
        //        System.out.println(solution.numDecodings("27"));
        //        System.out.println(solution.numDecodings("12"));
        System.out.println(solution.numDecodings("26"));
        System.out.println(solution.numDecodings("226"));
        System.out.println(Integer.valueOf(' '));

        //        System.out.println(solution.numDecodings("227"));
        //        System.out.println(solution.numDecodings("0"));
        //        System.out.println(solution.numDecodings("106"));
        //        System.out.println(solution.numDecodings("11106"));
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //226
        //        dp[0](a[6])->1
        //        dp[1](2,6,26)->3
        //        dp[2]
        //        dp[1,3,2]


        public int numDecodings(String s) {
            int n = s.length();
            s = " " + s;
            char[] cs = s.toCharArray();
            int[] dp = new int[n + 1];
            dp[0] = 1;
            for (int i = 1; i <= n; i++) {
                // c1 : 代表「当前位置」单独形成 item
                // c2 : 代表「当前位置」与「前一位置」共同形成 item
                int c1 = cs[i] - '0', c2 = (cs[i - 1] - '0') * 10 + (cs[i] - '0');
                // 如果 c1 属于有效值，那么 dp[i] 可以由 dp[i - 1] 转移过来
                if (1 <= c1 && c1 <= 9)
                    dp[i] = dp[i - 1];
                // 如果 c2 属于有效值，那么 dp[i] 可以由 dp[i - 2] 或者 dp[i - 1] & dp[i - 2] 转移过来
                if (10 <= c2 && c2 <= 26)
                    dp[i] += dp[i - 2];
            }
            return dp[n];

        }


        public int numDecodings2(String s) {
            int[] dp = new int[s.length() + 1];
            dp[0] = s.charAt(s.length() - 1) == '0' ? 0 : 1;
            for (int i = 1; i <= s.length(); i++) {
                int i_1_cnt = 0;
                char c = s.charAt(s.length() - 1 - i);
                char c1 = s.charAt(s.length() - i);

                //s[n]=a[i]+a[i-1]+s[n-2]
                //第一位如果是0-2之间,第二位1-6就可以有2个选择(a[i],a[i-1]
                if (i >= 2 && c > '0' && c < '3' && c1 <= '6') {
                    dp[i] += dp[i - 2];
                    //如果第一位1-3,但是第二位大于6,则只有1个选择(a[i],a[i-2])
                }
                if (c != '0') {
                    dp[i] += dp[i - 1];
                }


                //                dp[i] = i_1_cnt > 0 ? ((i >= 2 ? dp[i - 2] : 0) + i_1_cnt) : dp[i - 1];
            }
            return dp[s.length()];
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}