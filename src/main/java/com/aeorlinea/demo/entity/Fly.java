package com.aeorlinea.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

@Entity
public class Fly implements Serializable {
    @Id
    private int id;
    private LocalDate  startDate;
    private LocalDate  endDate;
    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;
    public Fly() {
    }

    public Fly(int id, LocalDate  startDate, LocalDate endDate) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate  getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate  startDate) {
        this.startDate = startDate;
    }

    public LocalDate  getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate  endDate) {
        this.endDate = endDate;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }


    @Override
    public String toString() {
        return "Fly{" +
                "id=" + id +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", city=" + city +
                '}';
    }
}
