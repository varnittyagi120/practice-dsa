package src.system.design.lld.builderpattern;

import javax.swing.text.Caret;

public class Car {
    private String engineName;
    private int wheels;
    private int seats;
    private boolean sunRoof;
    private boolean navigationSystem;
    private Car(CarBuilder carBuilder){
        this.engineName = carBuilder.engineName;
        this.wheels = carBuilder.wheels;
        this.seats = carBuilder.seats;
        this.sunRoof = carBuilder.sunRoof;
        this.navigationSystem = carBuilder.navigationSystem;
    }

    public String getEngineName() {
        return engineName;
    }

    public int getWheels() {
        return wheels;
    }

    public int getSeats() {
        return seats;
    }

    public boolean isSunRoof() {
        return sunRoof;
    }

    public boolean isNavigationSystem() {
        return navigationSystem;
    }

    @Override
    public String toString() {
        return "Car{" +
                "engineName='" + engineName + '\'' +
                ", wheels=" + wheels +
                ", seats=" + seats +
                ", sunRoof=" + sunRoof +
                ", navigationSystem=" + navigationSystem +
                '}';
    }

    public static class CarBuilder{
        private String engineName="honda";
        private int wheels=4;
        private int seats=3;
        private boolean sunRoof=true;
        private boolean navigationSystem=true;

        public CarBuilder setEngineName(String engineName) {
            this.engineName = engineName;
            return this;
        }

        public CarBuilder setWheels(int wheels) {
            this.wheels = wheels;
            return this;
        }

        public CarBuilder setSeats(int seats) {
            this.seats = seats;
            return this;
        }

        public CarBuilder setSunRoof(boolean sunRoof) {
            this.sunRoof = sunRoof;
            return this;
        }

        public CarBuilder setNavigationSystem(boolean navigationSystem) {
            this.navigationSystem = navigationSystem;
            return this;
        }

        public Car build(){
            return new Car(this);
        }
    }
}
