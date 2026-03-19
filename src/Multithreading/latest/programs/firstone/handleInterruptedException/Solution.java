package src.Multithreading.latest.programs.firstone.handleInterruptedException;

public class Solution {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new WorkerThread());
        thread.start();
        Thread.sleep(2000);
        thread.interrupt();
        System.out.println("thread is terminated properly");
    }
}
