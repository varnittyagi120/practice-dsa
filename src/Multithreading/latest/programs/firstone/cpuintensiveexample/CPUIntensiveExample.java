package src.Multithreading.latest.programs.firstone.cpuintensiveexample;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CPUIntensiveExample {
    private static final int NUM_CORES = Runtime.getRuntime().availableProcessors();
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(NUM_CORES);
        for(int i=0;i<10;i++){
            executorService.execute(()->{
                int sum = performComputation();
                System.out.println("result is computed by the thread "+Thread.currentThread().getName()+" "+sum);
            });
        }
    }

    private static int performComputation() {
        int sum = 0;
        for(int i=0;i<1_000_000;i++){
            sum += Math.sqrt(i);
        }
        return sum;
    }
}
