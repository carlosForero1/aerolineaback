package com.aeorlinea.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Passenger {
    @Id
    private int id;
}
