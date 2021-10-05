package leetcode.editor.cn;

//12-整数转罗马数字
public class P12_IntegerToRoman {

    public static void main(String[] args) {

        Solution solution = new P12_IntegerToRoman().new Solution();
        System.out.println(solution.intToRoman(1994));
        System.out.println(solution.intToRoman(58));
        System.out.println(solution.intToRoman(9));
        System.out.println(solution.intToRoman(1600));
        System.out.println(solution.intToRoman(1400));
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public String intToRoman(int num) {
            int[] array = {1, 5, 10, 50, 100, 500, 1000};
            String[] arrayStr = {"I", "V", "X", "L", "C", "D", "M"};

            //1200(M->200->200->MCC)
            //1600(M->600(D)->100(C)->MDC
            //1900(M900->D400->100(CD)->MCM
            //1400(M400->D400->100(CD)->MCD
            int left = num;
            int index = array.length - 1;
            StringBuilder sb = new StringBuilder();
            while (left > 0 && index >= 0) {
                int div = left / array[index];
                int leftNum = left % array[index];


                if (div > 0) {
                    for (int i = 0; i < div; i++) {
                        sb.append(arrayStr[index]);
                    }
                }
                boolean isOden = index % 2 == 0;
                //4和9的补位;只有偶数位才计算.9的时候补当前位
                if (isOden && index >= 2 && leftNum / array[index - 2] == 9) {
                    sb.append(arrayStr[index - 2]).append(arrayStr[index]);
                    left = leftNum % array[index - 2];
                    index = index - 2;
                    continue;
                }
                //4的时候补前一位
                if (isOden && index >= 2 && leftNum / array[index - 2] == 4) {
                    sb.append(arrayStr[index - 2]).append(arrayStr[index - 1]);
                    left = leftNum % array[index - 2];
                    index = index - 2;
                    continue;
                }
                left = left % array[index];
                index--;
            }
            return sb.toString();
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}