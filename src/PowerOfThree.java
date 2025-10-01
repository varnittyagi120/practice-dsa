package src;

public class PowerOfThree {
        public boolean isPowerOfThree(int n) {
            if(n==1){
                return true;
            }

            if(n<=0){
                return false;
            }
            int reminder = n%3;
            if(reminder!=0){
                return false;
            }
            return isPowerOfThree(n/3);
        }
}
//time complexity O(log(n))
//space complexity O(log(n))
