package com.example.testing.Classes;

public class Item {
    private double price;

    public Item(double price) {
        if(price > 0)
            this.price = price;
        else
            this.price = 0;
    }

    public double getPrice() {
        return price;
    }
}
