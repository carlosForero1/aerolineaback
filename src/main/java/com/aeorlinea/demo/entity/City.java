package com.aeorlinea.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.io.Serializable;

@Entity
public class City implements Serializable {
    @Id
    private int id;
    private String name;
    private Integer destiny;
    private double distance;

    public City() {
    }

    public City(int id, String name, int destiny, double distance) {
        this.id = id;
        this.name = name;
        this.destiny = destiny;
        this.distance = distance;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDestiny() {
        return destiny;
    }

    public void setDestiny(int destiny) {
        this.destiny = destiny;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", destiny='" + destiny + '\'' +
                ", distance=" + distance +
                '}';
    }
}
