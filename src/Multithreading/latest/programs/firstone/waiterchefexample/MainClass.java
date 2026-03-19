package src.Multithreading.latest.programs.firstone.waiterchefexample;

public class MainClass {
    public static void main(String[] args) {
        Object lock = new Object();
        Thread thread = new ChefThread(lock);
        Thread thread1 = new WaiterThread(lock);
        thread1.start();
        thread.start();
    }
}
