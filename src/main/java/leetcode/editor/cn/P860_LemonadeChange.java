package leetcode.editor.cn;

import java.util.LinkedList;


//860-柠檬水找零
public class P860_LemonadeChange {

    public static void main(String[] args) {

        Solution solution = new P860_LemonadeChange().new Solution();
        int[] a1 = {5, 5, 5, 10, 20};
        System.out.println(solution.lemonadeChange(a1));
        int[] a2 = {5, 5, 10, 10, 20};
        System.out.println(solution.lemonadeChange(a2));
        int[] a3 = {5, 5, 10};
        System.out.println(solution.lemonadeChange(a3));
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        //复杂度O(N),用时10分钟
        public boolean lemonadeChange(int[] bills) {
            //维护2个数组,
            LinkedList<Integer> five = new LinkedList<>();
            LinkedList<Integer> ten = new LinkedList<>();
            for (int i = 0; i < bills.length; i++) {
                if (bills[i] == 5) {
                    five.addLast(5);
                }else if (bills[i] == 10) {
                    //无法找零
                    if (five.size() < 1) {
                        return false;
                    }
                    ten.addLast(10);
                    five.removeLast();
                }else if (bills[i] == 20) {
                    if (five.isEmpty()) {
                        return false;
                    }

                    //有10元的
                    if (ten.size() > 0) {
                        ten.removeLast();
                        five.removeLast();
                        continue;
                    }
                    //只有五元
                    if (five.size() >= 3) {
                        five.removeLast();
                        five.removeLast();
                        five.removeLast();
                        continue;
                    }
                    //无法找零
                    return false;

                }
            }
            return true;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}