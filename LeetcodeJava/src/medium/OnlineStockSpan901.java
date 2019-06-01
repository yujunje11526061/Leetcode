package medium;

import java.util.ArrayList;
import java.util.List;

public class OnlineStockSpan901 {
    public static OnlineStockSpan901 instance = new OnlineStockSpan901();
    public StockSpanner stockSpanner = new StockSpanner();

    public static void main(String[] args) {
        int[] prices = {100, 80, 60, 70, 60, 75, 85};
        for(int price:prices) {
            System.out.println(instance.stockSpanner.next(price));
        }
    }

    class StockSpanner {
        private List<Integer> priceInfo;
        private List<Integer> prePeak;

        public StockSpanner() {
             this.priceInfo= new ArrayList<>();
             this.prePeak= new ArrayList<>();
        }

        public int next(int price) {
            priceInfo.add(price);
            int i= prePeak.size()-1;

            while(i>=0){
                if(priceInfo.get(i)>price){
                    break;
                }
                i = prePeak.get(i);
            }
            prePeak.add(i);
            return prePeak.size()-1-i;
        }
    }

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
}
