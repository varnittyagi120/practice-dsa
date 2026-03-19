package src.Multithreading.latest.programs.firstone.cachedpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class IOBoundExample {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for(int i=1;i<10;i++){
            executorService.execute(()->{
                simulation();
                System.out.println("completed I/O task..");
            });
        }
        executorService.shutdown();
    }

    private static void simulation() {
        try{
            System.out.println("waiting for the task to complete...");
            TimeUnit.MILLISECONDS.sleep(1000);
        } catch(InterruptedException exception){
            Thread.currentThread().interrupt();
        }
    }
}
