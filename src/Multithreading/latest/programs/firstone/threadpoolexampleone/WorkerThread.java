package src.Multithreading.latest.programs.firstone.threadpoolexampleone;

public class WorkerThread implements Runnable{
    int taskId;
    WorkerThread(int taskId){
        this.taskId = taskId;
    }
    @Override
    public void run() {
        try{
            System.out.println(Thread.currentThread().getName()+" executing the task "+taskId);
            Thread.sleep(2000);
        } catch (InterruptedException exception) {
             Thread.currentThread().interrupt();
        }
        System.out.println(Thread.currentThread().getName()+" has completed the task with taskId "+taskId);
    }
}
