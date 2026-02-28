package src.system.design.lld.factorypattern;

public class Car implements Vehicle {
    @Override
    public int start() {
        System.out.println("start the car");
        return 0;
    }

    @Override
    public int stop() {
        System.out.println("stop the car");
        return 0;
    }
}
