package src.Multithreading.latest.programs.firstone.usingrunnable;

import src.Multithreading.latest.programs.firstone.MyClass;

public class Myclass implements Runnable{
    @Override
    public void run() {
        System.out.println("some work is assigned to this thread"+Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new Myclass());
        thread.start();

    }
}
