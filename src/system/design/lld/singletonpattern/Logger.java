package src.system.design.lld.singletonpattern;

public class Logger {
    private static volatile Logger instance = null;

    public static Logger getInstance(){
        if(instance==null){
            synchronized (Logger.class){
                if(instance==null){
                    instance = new Logger();
                }
            }
        }
        return instance;
    }

    public void printLog(String message){
        System.out.println("print the message "+message);
    }
}
