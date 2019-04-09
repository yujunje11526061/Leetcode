package hard;

import java.util.ArrayList;
import java.util.Arrays;

public class BestTimetoBuyandSellStock_III123 {
    public static BestTimetoBuyandSellStock_III123 instance = new BestTimetoBuyandSellStock_III123();
    public Solution solution = new Solution();

    public static void main(String[] args) {
        int[] prices = {2,1,2,0,1};
        int result = instance.solution.maxProfit(prices);
        System.out.println(result);
    }

//    class Solution {
//        public int maxProfit(int[] prices) {
//            /**
//             对于任意一天考虑四个变量:
//             fstBuy: 在该天第一次买入股票可获得的最大收益
//             fstSell: 在该天第一次卖出股票可获得的最大收益
//             secBuy: 在该天第二次买入股票可获得的最大收益
//             secSell: 在该天第二次卖出股票可获得的最大收益
//             分别对四个变量进行相应的更新, 最后secSell就是最大
//             收益值(secSell >= fstSell)
//             **/
//            int fstBuy = Integer.MIN_VALUE, fstSell = 0;
//            int secBuy = Integer.MIN_VALUE, secSell = 0;
//            for(int p : prices) {
//                fstBuy = Math.max(fstBuy, -p);
//                fstSell = Math.max(fstSell, fstBuy + p);
//                secBuy = Math.max(secBuy, fstSell - p);
//                secSell = Math.max(secSell, secBuy + p);
//            }
//            return secSell;
//        }
//    }
//
//  此处先把递增序列拎出来，其实也可以直接扫两遍，O(n2)，
    class Solution {
        public int maxProfit(int[] prices) {
            if (prices == null || prices.length == 0) {
                return 0;
            }
            int buy = 0;
            int profits1 = 0;
            int profits2 = 0;
            int prev = 0;
            ArrayList<Integer> a = new ArrayList<>();
            for (int i = 1; i < prices.length; i++) {
                if (prices[i] >= prices[prev]) {
                    prev = i;
                } else {
                    if (buy < prev) {
                        a.add(prices[buy]);
                        a.add(prices[prev]);
                    }
                    buy = prev = i;
                }
            }
            if (buy < prev) {
                a.add(prices[buy]);
                a.add(prices[prev]);
            }
//            System.out.println(b);
//            System.out.println(s);
            int groupCnt = a.size() / 2;
            if (groupCnt == 0) {
                return 0;
            }
            if (groupCnt == 1) {
                return a.get(1) - a.get(0);
            }

//            System.out.println(a);
            int[] beforeMax = new int[groupCnt+1];
            int[] afterMax = new int[groupCnt+1];
            beforeMax[0] = 0;
            afterMax[groupCnt] = 0;

            int max = a.get(1)-a.get(0);
            int buyPrice = a.get(0);
            for (int i = 0; i < groupCnt; i++) {
                buyPrice = buyPrice>a.get(2*i)?a.get(2*i):buyPrice;
                max = max>=a.get(2*i+1)-buyPrice?max:a.get(2*i+1)-buyPrice;
                beforeMax[i+1] = max;

                int max2 = a.get(2*i+1)-a.get(2*i);
                int buyPrice2 = a.get(2*i);
                for(int j = i;j<groupCnt;j++){
                    buyPrice2  = buyPrice2>a.get(2*j)?a.get(2*j):buyPrice2;
                    max2 = max2>=a.get(2*j+1)-buyPrice2?max2:a.get(2*j+1)-buyPrice2;
                    afterMax[i] = max2;
            }


            }
//            System.out.println(Arrays.toString(beforeMax));
//            System.out.println(Arrays.toString(afterMax));
            int maxProfits = 0;
            int profits = 0;
            for(int k=0;k<groupCnt;k++){
                profits = afterMax[k]+beforeMax[k];
                maxProfits = maxProfits>profits?maxProfits:profits;
            }
            return maxProfits;
        }
    }
}
