package src.system.design.lld.abstractdesignpattern;

public class Toyota implements Vehicle{

    @Override
    public void start() {
        System.out.println("Toyota car is getting started...");
    }

    @Override
    public void end() {
        System.out.println("Toyota car is getting stopped...");
    }
}
