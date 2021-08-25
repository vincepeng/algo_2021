package leetcode.editor.cn;

//122-买卖股票的最佳时机 II
public class P122_BestTimeToBuyAndSellStockIi {

    public static void main(String[] args) {

        Solution solution = new P122_BestTimeToBuyAndSellStockIi().new Solution();
        int[] a = {7, 1, 5, 3, 6, 4};
        int[] a2 = {1, 2, 3, 4, 5};
        System.out.println(solution.maxProfit(a));
        System.out.println(solution.maxProfit(a2));
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int maxProfit(int[] prices) {
            if (prices.length == 0) {
                return 0;
            }
            int totalProfit = 0;
            int buyPrice = prices[0];
            for (int i = 1; i < prices.length; i++) {
                int currentPrice = prices[i];
                if (currentPrice < buyPrice) {
                    buyPrice = currentPrice;
                }else if (currentPrice > buyPrice) {
                    int soldPrice = currentPrice;
                    boolean notLastDay = i < prices.length - 1;
                    if (notLastDay) {
                        int nextPrice = prices[i + 1];
                        //下一个价格比当前高,则不卖出;
                        if (nextPrice > currentPrice) {
                            continue;
                            //下一个价格比当前价格低,则卖出
                        }else if (nextPrice < currentPrice) {
                            totalProfit += soldPrice - buyPrice;
                            //更新最新的购买价格
                            buyPrice = nextPrice;
                            continue;
                        }
                        //最后一个了,只有卖掉
                    }else {
                        totalProfit += soldPrice - buyPrice;
                    }
                }

            }
            return totalProfit;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}