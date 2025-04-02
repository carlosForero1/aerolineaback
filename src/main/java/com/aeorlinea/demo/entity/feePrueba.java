package com.aeorlinea.demo.entity;

public class feePrueba {

    private int id;

    private String description; // Descripción de la tarifa (por ejemplo, "Económica", "Ejecutiva", "Primera Clase")

    private String details; // Detalles adicionales sobre la tarifa

    // Constructores (opcional)
    public feePrueba() {
    }

    public feePrueba(int id, String description, String details) {
        this.id = id;
        this.description = description;
        this.details = details;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    @Override
    public String toString() {
        return "feePrueba{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", details='" + details + '\'' +
                '}';
    }
}
