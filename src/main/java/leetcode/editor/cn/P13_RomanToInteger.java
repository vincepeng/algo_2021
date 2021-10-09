package leetcode.editor.cn;

import java.util.HashMap;


//13-罗马数字转整数
public class P13_RomanToInteger {

    public static void main(String[] args) {

        Solution solution = new P13_RomanToInteger().new Solution();
        System.out.println(solution.romanToInt("III"));
        System.out.println(solution.romanToInt("IV"));
        System.out.println(solution.romanToInt("VI"));
        System.out.println(solution.romanToInt("LVIII"));
        System.out.println(solution.romanToInt("IX"));
        System.out.println(solution.romanToInt("XLIX"));
        System.out.println(solution.romanToInt("CMXCIX"));
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int romanToInt(String s) {
            int[] array = {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
            String[] arrayStr = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
            HashMap<String, Integer> map = new HashMap<>();
            for (int i = 0; i < arrayStr.length; i++) {
                map.put(arrayStr[i], array[i]);
            }
            int index = 0;
            int ret = 0;

            while (index < s.length()) {
                //2位
                if (index <= s.length() - 2) {
                    String substring = s.substring(index, index + 2);
                    Integer integer = map.get(substring);
                    if (integer != null) {
                        ret += integer;
                        index = index + 2;
                        continue;
                    }
                }
                String key = "" + s.charAt(index);
                ret += map.get(key);

                index++;
            }

            return ret;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}