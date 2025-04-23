package com.example.testing.Classes;

public class Bill {
    private double price;

    public Bill(double price) {
        if(price > 0)
            this.price = price;
        else
            this.price = 0;
    }

    public double getPrice() {
        return price;
    }
}
