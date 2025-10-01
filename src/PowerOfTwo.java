package src;

public class PowerOfTwo {
        public boolean isPowerOfTwo(int n) {
            if(n<=0){
                return false;
            }
            if(n==1){
                return true;
            }
            int reminder = n%2;
            if(reminder!=0){
                return false;
            }
            return isPowerOfTwo(n/2);
        }
}
//space complexity O(log(n))
//time complexity O(log(n))