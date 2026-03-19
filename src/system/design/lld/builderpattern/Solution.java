package src.system.design.lld.builderpattern;

public class Solution {
    public static void main(String[] args) {
        Car.CarBuilder builder = new Car.CarBuilder();
        Car car = builder.setEngineName("Maruti").setSeats(5).setWheels(4).setNavigationSystem(false).build();
        System.out.println(car.toString());;
    }
}
