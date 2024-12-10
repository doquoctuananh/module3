package model;

import jdk.nashorn.internal.runtime.regexp.joni.constants.StringType;

import java.time.LocalDate;

public class Car extends Vehicle {
    private int numerSeats;

    public Car(int id, String nameVehicle, String color, double price, LocalDate yearManufactured, int idPravince, int idPerson, int numerSeats) {
        super(id, nameVehicle, color, price, yearManufactured, idPravince, idPerson);
        this.numerSeats = numerSeats;
    }

    public Car(String nameVehicle, String color, double price, LocalDate yearManufactured, int idPravince, int idPerson, String typeVehicle, int numerSeats) {
        super(nameVehicle, color, price, yearManufactured, idPravince,idPerson,typeVehicle);
        this.numerSeats = numerSeats;
    }

    public Car(int id, String nameVehicle, String color, double price, LocalDate yearManufactured, int idProvince, int idPerson, String typeVehicle, int numerSeats) {
        super(id, nameVehicle, color, price, yearManufactured, idProvince, idPerson, typeVehicle);
        this.numerSeats = numerSeats;
    }

    public int getNumerSeats() {
        return numerSeats;
    }

    public void setNumerSeats(int numerSeats) {
        this.numerSeats = numerSeats;
    }
}
