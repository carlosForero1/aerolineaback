package com.aeorlinea.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Fee {
    @Id
    private int id;

    private String nombre;

    private double costo;
    private String descripcion;
    private double precioAsistenMedic;
}
