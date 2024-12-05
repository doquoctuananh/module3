package model;

public class Province {
    private int code;
    private String name;

    public Province(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public Province(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
