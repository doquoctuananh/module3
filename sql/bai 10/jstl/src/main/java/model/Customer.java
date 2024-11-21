package model;

import java.io.File;
import java.time.LocalDate;

public class Customer {
    private String name;
    private LocalDate birthday;
    private String address;
    private String image;

    public Customer(String name, LocalDate birthday, String address,String image) {
        this.name = name;
        this.birthday = birthday;
        this.address = address;
        this.image = image;
    }

    public Customer(String name, LocalDate birthday, String address) {
        this.name = name;
        this.birthday = birthday;
        this.address = address;

    }

    public Customer() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }
    public void setImage(String image) {
        this.image = image;
    };
    public String getImage() {
        return image;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
