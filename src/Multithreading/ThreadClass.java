package src.Multithreading;

public class ThreadClass extends Thread{
    public void run(){
        System.out.println("inside the thread class "+ Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        ThreadClass threadClass = new ThreadClass();
        threadClass.start();
        System.out.println("inside the thread class "+ Thread.currentThread().getName());
    }
}
