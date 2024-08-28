package com.firsttry.clothingapp.model;

public class Item {
    private String color,description,img,material,name,price,rating;
    private  Boolean inStock;

    public Item(String color, String description, String img, String material, String name, String price,String rating) {
        this.color = color;
        this.description = description;
        this.img = img;
        this.material = material;
        this.name = name;
        this.price = price;
        this.rating = rating;
    }

    public String getColor() {
        return color;
    }

    public String getDescription() {
        return description;
    }

    public String getImg() {
        return img;
    }

    public String getMaterial() {
        return material;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public Boolean getInStock() {
        return inStock;
    }

    public String getRating() {
        return rating;
    }
}
