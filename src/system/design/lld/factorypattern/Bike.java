package src.system.design.lld.factorypattern;

public class Bike implements Vehicle {
    @Override
    public int start() {
        System.out.println("start the bike");
        return 0;
    }

    @Override
    public int stop() {
        System.out.println("stop the bike");
        return 0;
    }
}
