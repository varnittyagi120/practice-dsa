package src.system.design.lld.factorypattern;

public class VehicleFactory {
    public static Vehicle getVehicleInstance(String instanceType){
        Vehicle vehicle = null;
        if(instanceType.equalsIgnoreCase("Car")){
            vehicle = new Car();
        } else if(instanceType.equalsIgnoreCase("Truck")){
            vehicle = new Truck();
        } else if(instanceType.equalsIgnoreCase("Bike")){
            vehicle = new Bike();
        } else {
            throw new RuntimeException("instance type is wrong");
        }
        return vehicle;
    }
}
// advantages of the factory pattern
// centralization of object creation
// Scalable --> easy to add new vehicles
// Encapsulation with abstraction, main class does not know how the objects are being created 
