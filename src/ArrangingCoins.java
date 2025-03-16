package src;

public class ArrangingCoins {
        public int arrangeCoins(int n) {
            int low = 1;
            int high = n;
            int result = 1;
            while(low<=high){
                int mid = low + ((high-low)/2);
                if(n*2L < (mid * (mid+1L))){
                    high = mid-1;
                } else {
                    low = mid+1;
                }
            }
            return high;
        }
}
