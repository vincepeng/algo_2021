package leetcode.editor.cn;

import java.util.Arrays;


//322-零钱兑换
public class P322_CoinChange {

    public static void main(String[] args) {

        Solution solution = new P322_CoinChange().new Solution();
        int[] a = {186, 419, 83, 408};
        System.out.println(solution.coinChange(a, 6249));
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {


        public int coinChange(int[] coins, int amount) {
            //重复最小单元dp[total]=min(dp[total-coin[i]])+1
            //动态数组,就用dp[total]=cnt来;
            //方程组
            //因为从0开始,这里要算到amount所以多一个;
            int[] dp = new int[amount + 1];
            //随便放一个值就可以;由于硬币最大值为int.max,但是amount最大值为10^4,所以这里没关系,不会溢出;
            //因为就是使用1,也最多amount,这里加1证明永远会小于这个值;
            Arrays.fill(dp, amount + 1);
            dp[0] = 0;
            //至底向上遍历
            for (int i = 1; i <= amount; i++) {
                //这里其实是和硬币数组里面所有的进行对比,因此使用dp[i]最为中间变量,与每一个比完即可;
                //第一次比的时候是初始值,按照最差用1元进行汇总来说,最大就是amount了,因此第一次比一定是有硬币的会覆盖掉默认值;
                for (int j = 0; j < coins.length; j++) {
                    //剩余的钱数要大于当前硬币数,否则就没有意义了
                    if (i >= coins[j]) {
                        dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                    }
                }
            }
            //如果大于amount,证明是最初的赋值,因此没有找到
            return dp[amount] > amount ? -1 : dp[amount];
        }


        public int test(int[] coins, int amount) {
            {
                if (amount == 0) {
                    return 0;
                }
                //O(nlogn),使用贪心,每一步优先使用最大的数来整除,最后得到的一定是次数最少的;
                Arrays.sort(coins);
                int[] dp = new int[coins.length];
                int sum = 0;
                do {
                    int left = amount;
                    //从导数第二个开始减少
                    for (int i = 1; i < dp.length; i++) {
                        if (dp[i] > 0) {
                            dp[i] = dp[i] - 1;
                            dp = new int[coins.length];
                        }else {
                            for (int j = coins.length - 1; j >= 0; j--) {
                                //从最大的开始减少开始
                                if (dp[j] > 0) {

                                }else {
                                    int num = left / coins[i];
                                    if (num > 0) {
                                        //继续往小的变;
                                        left = left % coins[i];
                                        dp[i] = num;
                                    }
                                }

                                //如果已经为0了,则可以提前结束了
                                if (left == 0) {
                                    return Arrays.stream(dp).sum();
                                }
                            }
                        }

                    }

                }
                while (Arrays.stream(dp).sum() > 0);
                return -1;
            }
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)

}