package src.Multithreading.latest.programs.firstone.avoidthreadleaks;

public class SafeLock {
    Object lock = new Object();
    void waitForSignal() {
        synchronized(lock) {
                try {
                    System.out.println(Thread.currentThread().getName() + " thread is waiting...");
                    lock.wait(2000);
                } catch (InterruptedException exception) {
                    Thread.currentThread().interrupt();
                }
        }
    }
}
