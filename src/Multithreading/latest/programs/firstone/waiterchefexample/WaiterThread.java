package src.Multithreading.latest.programs.firstone.waiterchefexample;

public class WaiterThread extends Thread {
    Object lock;
    WaiterThread(Object lock){
        this.lock = lock;
    }
    @Override
    public void run(){
        synchronized (lock){
            try {
                System.out.println("Waiter is waiting for the food to be prepared....");
                lock.wait();
                System.out.println("Waiter food is ready, ready to deliver to the customer....");
            } catch(InterruptedException ex){
                Thread.currentThread().interrupt();
            }
        }
    }
}
