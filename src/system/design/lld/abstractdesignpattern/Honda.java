package src.system.design.lld.abstractdesignpattern;

public class Honda implements Vehicle{
    @Override
    public void start() {
        System.out.println("Honda car engine is getting started..");
    }

    @Override
    public void end() {
        System.out.println("Honda car engine is getting stopped..");
    }
}
