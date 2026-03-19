package src.Multithreading.latest.programs.firstone;

public class MyClass extends Thread{

    @Override
    public void run(){
        System.out.println("this is a thread class : "+Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        MyClass myClass = new MyClass();
        myClass.start();
    }
}
