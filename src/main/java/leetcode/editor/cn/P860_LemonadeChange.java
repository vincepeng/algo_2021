package leetcode.editor.cn;

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
            int five = 0, ten = 0;

            for (int i = 0; i < bills.length; i++) {
                if (bills[i] == 5) {
                    five++;
                }else if (bills[i] == 10) {
                    //无法找零
                    if (five < 1) {
                        return false;
                    }
                    ten++;
                    five--;

                }else if (bills[i] == 20) {
                    if (five == 0) {
                        return false;
                    }

                    //有10元的
                    if (ten > 0) {
                        ten--;
                        five--;
                        continue;
                    }
                    //只有五元
                    if (five >= 3) {
                        five -= 3;
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