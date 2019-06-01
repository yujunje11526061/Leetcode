package easy;

public class BestTimetoBuyandSellStock121 {
    public static BestTimetoBuyandSellStock121 instance = new BestTimetoBuyandSellStock121();
    public Solution solution = new Solution();

    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        System.out.println(instance.solution.maxProfit(prices));
    }
    class Solution {
        public int maxProfit(int[] prices) {
            if(prices==null||prices.length==0){
                return 0;
            }
            int[] toBuy = new int[prices.length];
            int[] toSell = new int[prices.length];
            toBuy[0] = -prices[0];
            toSell[0] = 0;
            int maxProfit = 0;
            for(int i=1;i<prices.length;i++){
                toBuy[i] = Integer.max(-prices[i],toBuy[i-1]);
                toSell[i] = Integer.max(prices[i]+toBuy[i],toSell[i-1]);
                maxProfit = Integer.max(maxProfit,toSell[i]);
            }
            return maxProfit;
        }
    }
}
