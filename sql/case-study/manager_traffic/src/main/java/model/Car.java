package model;

import java.time.LocalDate;

public class Car extends Vehicle {
    private int numerSeats;

    public Car(int id, String nameVehicle, String color, double price, LocalDate yearManufactured, int idPravince, int idPerson, int numerSeats) {
        super(id, nameVehicle, color, price, yearManufactured, idPravince, idPerson);
        this.numerSeats = numerSeats;
    }

    public int getNumerSeats() {
        return numerSeats;
    }

    public void setNumerSeats(int numerSeats) {
        this.numerSeats = numerSeats;
    }
}
