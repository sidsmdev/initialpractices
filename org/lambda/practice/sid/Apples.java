package org.lambda.practice.sid;

public class Apples {

    private String Color;
    private Integer weight;
    private Integer price;


    public String getColor() {
        return Color;
    }

    public void setColor(String color) {
        Color = color;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Apples(String color, Integer weight, Integer price) {
        Color = color;
        this.weight = weight;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Apples [Color=" + Color + ", price=" + price + ", weight=" + weight + "]";
    }

    
}