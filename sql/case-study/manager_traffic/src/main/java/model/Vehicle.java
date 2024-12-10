package model;

import java.time.LocalDate;

public class Vehicle {
    private int id;
    private String nameVehicle;
    private String color;
    private double price;
    private LocalDate yearManufactured;
    private int IdProvince;
    private int IdPerson;
    private String typeVehicle;

    public Vehicle(int id, String nameVehicle, String color, double price, LocalDate yearManufactured, int idPravince, int idPerson) {
        this.id = id;
        this.nameVehicle = nameVehicle;
        this.color = color;
        this.price = price;
        this.yearManufactured = yearManufactured;
        this.IdProvince = idPravince;
        this.IdPerson = idPerson;
    }

    public Vehicle( String nameVehicle, String color, double price, LocalDate yearManufactured, int idPravince, int idPerson) {

        this.nameVehicle = nameVehicle;
        this.color = color;
        this.price = price;
        this.yearManufactured = yearManufactured;
        this.IdProvince = idPravince;
        this.IdPerson = idPerson;
    }

    public Vehicle(String nameVehicle, String color, double price, LocalDate yearManufactured,int idProvince, int idPerson, String typeVehicle) {
        this.nameVehicle = nameVehicle;
        this.color = color;
        this.price = price;
        IdProvince = idProvince;
        this.yearManufactured = yearManufactured;
        IdPerson = idPerson;
        this.typeVehicle = typeVehicle;
    }

    public Vehicle(int id, String nameVehicle, String color, double price, LocalDate yearManufactured, int idProvince, int idPerson, String typeVehicle) {
        this.id = id;
        this.nameVehicle = nameVehicle;
        this.color = color;
        this.price = price;
        this.yearManufactured = yearManufactured;
        IdProvince = idProvince;
        IdPerson = idPerson;
        this.typeVehicle = typeVehicle;
    }

    public String getTypeVehicle() {
        return typeVehicle;
    }

    public void setTypeVehicle(String typeVehicle) {
        this.typeVehicle = typeVehicle;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameVehicle() {
        return nameVehicle;
    }

    public void setNameVehicle(String nameVehicle) {
        this.nameVehicle = nameVehicle;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public LocalDate getYearManufactured() {
        return yearManufactured;
    }

    public void setYearManufactured(LocalDate yearManufactured) {
        this.yearManufactured = yearManufactured;
    }

    public int getIdProvince() {
        return IdProvince;
    }

    public void setIdProvince(int IdProvince) {
        IdProvince = IdProvince;
    }

    public int getIdPerson() {
        return IdPerson;
    }

    public void setIdPerson(int idPerson) {
        IdPerson = idPerson;
    }


}
