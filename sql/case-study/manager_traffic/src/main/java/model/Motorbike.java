package model;

import java.time.LocalDate;

public class Motorbike extends Vehicle {
    private double speed;

    public Motorbike(int id, String nameVehicle, String color, double price, LocalDate yearManufactured, int idPravince, int idPerson, double speed) {
        super(id, nameVehicle, color, price, yearManufactured, idPravince, idPerson);
        this.speed = speed;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }
}
