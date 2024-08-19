package com.firsttry.clothingapp.model;

public class Item {
    private String color,description,img,material,name,price;
    private  Boolean inStock;

    public Item(String color, String description, String img, String material, String name, String price) {
        this.color = color;
        this.description = description;
        this.img = img;
        this.material = material;
        this.name = name;
        this.price = price;
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
}
