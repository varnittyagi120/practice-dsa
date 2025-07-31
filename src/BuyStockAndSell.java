package src;

public class BuyStockAndSell {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int i = 0;
        for(int j=0;j<prices.length;j++){
            if(prices[j] < prices[i]){
                i = j;
            }
            if(prices[j]>prices[i] && (prices[j]-prices[i])>profit){
                profit = prices[j]-prices[i];
            }
        }
        return profit;
    }
}
