package src.gasstation;

public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0;
        int totalCost = 0;
        int start = 0;
        int currentSum = 0;
        for(int i=0;i<gas.length;i++){
            totalGas += gas[i];
            totalCost += cost[i];
            currentSum = currentSum + gas[i] - cost[i];
            if(currentSum<0){
                start = i+1;
                currentSum = 0;
            }
        }

        if(totalGas < totalCost){
            return -1;
        }
        return start;
    }
}
