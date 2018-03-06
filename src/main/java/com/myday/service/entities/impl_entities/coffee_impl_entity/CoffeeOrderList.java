package com.myday.service.entities.impl_entities.coffee_impl_entity;

public class CoffeeOrderList {
    private String name;
    private int countCups;
    private double price;

    public CoffeeOrderList(String name, int countCups, double price) {
        this.name = name;
        this.countCups = countCups;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCountCups() {
        return countCups;
    }

    public void setCountCups(int countCups) {
        this.countCups = countCups;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
