package src.Multithreading.latest.programs.firstone.threadpoolexecutorqueuesize;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Solution {
    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 10, 20, TimeUnit.SECONDS, new ArrayBlockingQueue<>(2), new ThreadPoolExecutor.AbortPolicy());

        for(int i=0;i<=10;i++){
                int taskId = i;
                threadPoolExecutor.execute(()->{
                    System.out.println(Thread.currentThread().getName()+" is waiting for the task to complete taskId "+taskId);
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                });
        }
        threadPoolExecutor.shutdown();
    }
}
