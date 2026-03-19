package src.system.design.lld.abstractdesignpattern;

public class HondaFactory implements VehicleFactory{
    @Override
    public Vehicle createFactory() {
        return new Honda();
    }
}
