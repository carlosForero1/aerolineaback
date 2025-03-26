package com.aeorlinea.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.io.Serializable;
import java.util.Date;

@Entity
public class Fly implements Serializable {
    @Id
    private int id;
    private Date startDate;
    private Date endDate;

    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;
    public Fly() {
    }

    public Fly(int id, Date startDate, Date endDate) {
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

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
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
