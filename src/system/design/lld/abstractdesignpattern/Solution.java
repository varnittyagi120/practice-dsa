package src.system.design.lld.abstractdesignpattern;

public class Solution {
    public static void main(String[] args) {
        VehicleFactory hondaFactory = new HondaFactory();
        Vehicle vehicle = hondaFactory.createFactory();
        vehicle.start();
        vehicle.end();

        VehicleFactory toyotaFactory = new ToyotaFactory();
        Vehicle toyotaVehicle = toyotaFactory.createFactory();
        toyotaVehicle.start();
        toyotaVehicle.end();
    }
}
