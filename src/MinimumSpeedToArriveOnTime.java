package src;
public class MinimumSpeedToArriveOnTime {
        public int minSpeedOnTime(int[] dist, double hour) {
            if(dist.length>Math.ceil(hour)){
                return -1;
            }
            return findMinimumNumber(dist, hour);
        }

        private int findMinimumNumber(int[] dist, double hour) {
            int low = 1;
            final int maximumValue = (int)1e7;
            int high = maximumValue+1;
            while (low<high) {
                int mid = low + ((high-low)/2);
                if(checkSpeed(mid, dist, hour)){
                    high = mid;
                } else {
                    low = mid+1;
                }
            }
            return low>maximumValue?-1:low;
        }

        private  boolean checkSpeed(int mid, int[] dist, double hour) {
            double result = 0;
            for(int i=0;i<dist.length;i++){
                if(i==dist.length-1){
                    result += (dist[i]*1.0)/mid;
                } else {
                    double temp = (dist[i]*1.0)/mid;
                    result+= Math.ceil(temp);
                }
            }
            return result<=hour;
        }
}

//1 3 2
//6.77777

//1
