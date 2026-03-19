package src.system.design.lld.abstractdesignpattern;

public class ToyotaFactory implements VehicleFactory{

    @Override
    public Vehicle createFactory() {
        return new Toyota();
    }
}
