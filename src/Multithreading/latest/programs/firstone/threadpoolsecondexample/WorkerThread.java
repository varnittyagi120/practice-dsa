package src.Multithreading.latest.programs.firstone.threadpoolsecondexample;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class WorkerThread implements Runnable{
    int taskId;
    WorkerThread(int taskId){
        this.taskId = taskId;
    }
    @Override
    public void run() {
        try{
            Thread.sleep(2000);
            synchronized (this){
                System.out.println(Thread.currentThread().getName()+" waiting on task "+taskId);
                this.wait(1000);
            }
        } catch(InterruptedException exception){
            Thread.currentThread().interrupt();
        }
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        for(int i=1; i<=5; i++){
            executorService.submit(new WorkerThread(i));
        }

        executorService.shutdown();
        System.out.println("threads are terminated.....");
        try{
            if(!executorService.awaitTermination(10, TimeUnit.SECONDS)){
               executorService.shutdownNow();
                System.out.println("Force shut down....");
            }
        } catch(InterruptedException exception){
            Thread.currentThread().interrupt();
        }
    }

}
