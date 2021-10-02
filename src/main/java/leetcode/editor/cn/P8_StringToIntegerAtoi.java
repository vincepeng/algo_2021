package leetcode.editor.cn;

//8-字符串转换整数 (atoi)
public class P8_StringToIntegerAtoi {

    public static void main(String[] args) {

        Solution solution = new P8_StringToIntegerAtoi().new Solution();
        System.out.println(solution.myAtoi("2147483646"));
        System.out.println(solution.myAtoi("+1"));
        System.out.println(solution.myAtoi("-1"));
        System.out.println(solution.myAtoi("00000-42a1234"));
        System.out.println(solution.myAtoi("-42"));
        System.out.println(solution.myAtoi("-4193 with words"));
        System.out.println(solution.myAtoi("words and 987"));
        System.out.println(solution.myAtoi("-91283472332"));
        System.out.println(Integer.MAX_VALUE + "--2147483646--" + "2147483647");

    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int myAtoi(String s) {
            if (s == null || s.length() == 0) {
                return 0;
            }
            //1.移除空格
            int start = 0;
            while (start < s.length()) {
                if (s.charAt(start) == ' ') {
                    start++;
                }else {
                    break;
                }
            }
            if (start >= s.length()) {
                return 0;
            }
            //2.判断是否有符号位
            boolean isNegativeFlag = false;
            //有负号
            if (s.charAt(start) == '-') {
                isNegativeFlag = true;
                start++;
                //有正号
            }else if (s.charAt(start) == '+') {
                start++;
            }
            if (start >= s.length()) {
                return 0;
            }
            //3.移除多余的0;
            while (start < s.length()) {
                if (s.charAt(start) == '0') {
                    start++;
                }else {
                    break;
                }
            }
            if (start >= s.length()) {
                return 0;
            }
            //4.转化数字
            int result = 0;
            while (start < s.length()) {
                char c = s.charAt(start);
                //5.判断非数字
                boolean isNum = c >= '0' && c <= '9';
                if (!isNum) {
                    return result;//如果是第一个result此时为0,则没有意义,直接返回0.否则是后面有数字,返回result当前的值;
                }
                int currentNum = c - '0';

                //6.判断是否溢出
                if (result > (Integer.MAX_VALUE - currentNum) / 10) {
                    return Integer.MAX_VALUE;
                }else if (result < (Integer.MIN_VALUE + currentNum) / 10) {
                    return Integer.MIN_VALUE;
                }else {
                    //7.计算结果
                    result = result * 10 + (result >= 0 ? currentNum : -currentNum);
                    //8.由于前面已经移除0了,所以这里可以直接使用符号位,使用后移除标志;
                    if (isNegativeFlag) {
                        result = result * -1;
                        isNegativeFlag = false;
                    }

                }
                start++;
            }

            return result;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}