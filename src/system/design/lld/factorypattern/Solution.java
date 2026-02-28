package src.system.design.lld.factorypattern;

public class Solution {
    public static void main(String[] args) {
        Vehicle vehicle1 = VehicleFactory.getVehicleInstance("Car");
        vehicle1.start();
        vehicle1.stop();
        Vehicle vehicle2 = VehicleFactory.getVehicleInstance("Truck");
        vehicle2.start();
        vehicle2.stop();
        Vehicle vehicle3 = VehicleFactory.getVehicleInstance("Bike");
        vehicle3.start();
        vehicle3.stop();
    }
}
