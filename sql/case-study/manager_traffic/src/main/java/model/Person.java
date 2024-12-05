package model;

import java.time.LocalDate;

public class Person {
    private int id;
    private String name;
    private LocalDate birthday;
    private String address;
    private String email;
    private String phone;
    private int id_province;

    public Person(int id, String name, LocalDate birthday, String address, String email, String phone, int id_province) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.address = address;
        this.email = email;
        this.phone = phone;
        this.id_province = id_province;
    }

    public Person(String name, LocalDate birthday, String address, String email, String phone, int id_province) {
        this.name = name;
        this.birthday = birthday;
        this.address = address;
        this.email = email;
        this.phone = phone;
        this.id_province = id_province;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getId_province() {
        return id_province;
    }

    public void setId_province(int id_province) {
        this.id_province = id_province;
    }
}
