package com.myday.service.entities.impl_entities.coffee_impl_entity;

import javax.persistence.*;

@Entity
@Table(name = "coffee_entity")
public class CoffeeEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private double price;

    public CoffeeEntity() {}

    @Override
    public String toString() {
        return "User {id = " + id + " name = " + name + " price = " + price;
    }

    public CoffeeEntity(String name, double price) {
        this.name = name;
        this.price = price;
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








    /*public CoffeeEntity(String name, double price) {
        super(name, price);
    }

    public CoffeeEntity(String name, double price, int count) {
        super(name, price, count);
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }

    @Override
    public double getPrice() {
        return super.getPrice();
    }

    @Override
    public void setPrice(double price) {
        super.setPrice(price);
    }

    @Override
    public int getCount() {
        return super.getCount();
    }

    @Override
    public void setCount(int count) {
        super.setCount(count);
    }*/
}
