package leetcode.editor.cn;

import java.util.LinkedList;


//415-字符串相加
public class P415_AddStrings {

    public static void main(String[] args) {

        Solution solution = new P415_AddStrings().new Solution();
        System.out.println(solution.addStrings("9", "9"));
        System.out.println(solution.addStrings("123456789", "987654321"));
        System.out.println(solution.addStrings("19", "2"));
        System.out.println(solution.addStrings("29", "287"));
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public String addStrings(String num1, String num2) {
            //            return useList(num1, num2);
            return useWhile(num1, num2);
        }


        private String useList(String num1, String num2) {
            if (num1 == null || num2 == null) {
                return "";
            }
            if (num1.length() == 0) {
                return num2;
            }
            if (num2.length() == 0) {
                return num1;
            }

            char[] aArray = num1.toCharArray();
            char[] bArray = num2.toCharArray();
            LinkedList<Character> aQueue = new LinkedList<>();
            LinkedList<Character> bQueue = new LinkedList<>();
            for (int i = 0; i < aArray.length; i++) {
                aQueue.add(aArray[i]);
            }
            for (int i = 0; i < bArray.length; i++) {
                bQueue.add(bArray[i]);
            }
            LinkedList<Integer> rets = new LinkedList<>();
            int left = 0;
            while (aQueue.size() > 0 || bQueue.size() > 0) {
                int a = aQueue.peekLast() != null ? Integer.valueOf(aQueue.pollLast() + "") : 0;
                int b = bQueue.peekLast() != null ? Integer.valueOf(bQueue.pollLast() + "") : 0;
                int temp = a + b + left;
                if (temp >= 10) {
                    left = temp / 10;
                    rets.addFirst(temp % 10);
                }else {
                    rets.addFirst(temp);
                    left = 0;
                }
            }
            if (left != 0) {
                rets.addFirst(left);
            }
            StringBuilder sb = new StringBuilder();
            while (rets.size() > 0) {
                sb.append(rets.pollFirst());
            }
            return sb.toString();
        }


        private String useWhile(String num1, String num2) {

            int i = num1.length() - 1, j = num2.length() - 1;
            int carry = 0;
            StringBuilder sb = new StringBuilder();
            while (i >= 0 || j >= 0) {
                int a = i >= 0 ? num1.charAt(i) - '0' : 0;
                int b = j >= 0 ? num2.charAt(j) - '0' : 0;
                int ret = a + b + carry;
                sb.append(ret % 10);
                carry = ret / 10;
                i--;
                j--;
            }
            if (carry == 1) {
                sb.append(1);
            }
            return sb.reverse().toString();

        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}