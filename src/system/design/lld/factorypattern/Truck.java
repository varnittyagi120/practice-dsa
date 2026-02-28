package src.system.design.lld.factorypattern;

public class Truck implements Vehicle {
    @Override
    public int start() {
        System.out.println("start the truck");
        return 0;
    }

    @Override
    public int stop() {
        System.out.println("stop the truck");
        return 0;
    }
}
