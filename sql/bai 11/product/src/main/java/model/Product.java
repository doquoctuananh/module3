package model;

public class Product {
    private static int count =0;
    private int id;
    private String name;
    private double price;
    private String color;
    private String description;

    public Product() {
    }

    public Product(String name, double price, String color, String description) {
        Product.setCount(Product.getCount()+1);
        this.id = Product.getCount();
        this.name = name;
        this.price = price;
        this.color = color;
        this.description = description;
    }



    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Product.count = count;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
