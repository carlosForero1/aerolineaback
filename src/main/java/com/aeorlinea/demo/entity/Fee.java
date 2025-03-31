package com.aeorlinea.demo.entity;

import jakarta.persistence.*;

@Entity
public class Fee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private int type;

    @Column(nullable = false)
    private double price;

    private boolean esPersonalizado;

    @ManyToOne
    @JoinColumn(name = "flight_id", nullable = false)
    private Fly flight;

    public Fee() {
    }

    public Fee(Integer id, int type, double price, boolean esPersonalizado, Fly flight) {
        this.id = id;
        this.type = type;
        this.price = price;
        this.esPersonalizado = esPersonalizado;
        this.flight = flight;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isEsPersonalizado() {
        return esPersonalizado;
    }

    public void setEsPersonalizado(boolean esPersonalizado) {
        this.esPersonalizado = esPersonalizado;
    }

    public Fly getFlight() {
        return flight;
    }

    public void setFlight(Fly flight) {
        this.flight = flight;
    }

    @Override
    public String toString() {
        return "Fee{" +
                "id=" + id +
                ", type=" + type +
                ", price=" + price +
                ", esPersonalizado=" + esPersonalizado +
                ", flight=" + flight +
                '}';
    }
}
