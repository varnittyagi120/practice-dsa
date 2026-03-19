package src.Multithreading.latest.programs.firstone.handleInterruptedException;

public class WorkerThread implements Runnable{
    @Override
    public void run() {
        try{
            while(!Thread.currentThread().isInterrupted()){
                System.out.println("some work is being processed..");
                Thread.sleep(2000);
            }
        } catch (InterruptedException exception) {
            Thread.currentThread().interrupt();
        }
    }
}
