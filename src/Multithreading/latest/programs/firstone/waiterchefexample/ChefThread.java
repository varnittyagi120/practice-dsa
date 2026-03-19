package src.Multithreading.latest.programs.firstone.waiterchefexample;

public class ChefThread extends Thread {
    private final Object lock;
    ChefThread(Object lock){
        this.lock = lock;
    }

    @Override
    public void run(){
            try{
                Thread.sleep(2000);
                synchronized (lock) {
                    System.out.println("Food is ready notify the waiter to serve");
                    lock.notify();
                }
            }catch(InterruptedException ex){
                Thread.currentThread().interrupt();
            }
    }
}
