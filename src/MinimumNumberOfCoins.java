package src;

public class MinimumNumberOfCoins {
        public int findMin(int n) {
            // code here
            int[] currency = {10,5,2,1};
            int result = 0;
            int i = 0;
            while(n>0 && i<4){
                if(n>=currency[i]){
                    result += n/currency[i];
                    n = n%currency[i];
                } else {
                    i++;
                }
            }
            return result;
        }
}
