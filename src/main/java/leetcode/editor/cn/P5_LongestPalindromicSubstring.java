package leetcode.editor.cn;

//5-最长回文子串
public class P5_LongestPalindromicSubstring {

    public static void main(String[] args) {

        Solution solution = new P5_LongestPalindromicSubstring().new Solution();
        System.out.println(solution.longestPalindrome("abb"));
        System.out.println(solution.longestPalindrome(
                "dumpyxybklgdwxbmhptxdckihigddiqzcyvhjhxdekozqxkwaiassrxalcnrlqjbakekgkbpsznmxfvdlhjuokdvzuetuoargsrrfboenozkrglrjnmlsntrxafvqfjniugdzxeutyjybdqfyqmqlkhgvryuwegoibobkstpirzdaspjyxddnyniaywgziqbmkwqaotxirlimlhiuxoyxwsnnmsyzpfxlatnpdqvbiafzqkfssetleiobwwpubzumgittqtrjzeioxkrujkdgzfykyypvnpsxnouxeeqmarjploacjntpixpglugxtiwycmeywhnjyqsmbgxchhtlpjesmhoaskatbfvqodtboozgwlpqclkigpqzvatavdzvgoibmygjsskynldvxevbprdxzpqcpuokyqyseyrekoiipoytftnwqawykfpcqriuazjoqucjkyknmcbiykqerpxxdkqlxvlijqegpexvylgkqygbgkicwmplnwubjwqnarulzlbrdftmzyrzhrmfqoiwzlncdreqaiipnqlwffxircopksnwizmyvzfphlqlvqpcsfjmyssrheczllgkvnretmtixoibncraddatreejidxilnplcrufhdgktvkzuaggcumykgklypodjrpdpjcneagjfxahtjeurotkufkmxsoelzpttfeugdculuxjddghlisdytyjwwnftjbvrwyntqwqjrwlfynczndjyiyaxozdlgdzjseyfumvxuclmszawzwiunwqouycmfgkpzgivsemxamnfjzcabkgkgxcruqhpbkzhpdrcexnioaxbjwxbuipnjbsujajpnqeckfgxyuydytrfhhwsxfjeahpiaoojdwkzstnxflxddljpbhfirteejbtcxpvwutsgrrjv"));
        //        System.out.println(solution.longestPalindrome2("cabbac"));
        //        System.out.println(solution.longestPalindrome2("babad"));
        //        System.out.println(solution.longestPalindrome2("cbbd"));
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public String longestPalindrome(String s) {
            for (int i = 0; i < s.length(); i++) {


            }
            return null;
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