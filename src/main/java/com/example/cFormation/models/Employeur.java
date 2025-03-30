package com.example.cFormation.models;

import jakarta.persistence.*;


@Entity
@Table(name = "employeur")
public class Employeur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @Column(nullable = false, unique = true)
    private String nomEmployeur;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomEmployeur() {
        return nomEmployeur;
    }

    public void setNomEmployeur(String nomEmployeur) {
        this.nomEmployeur = nomEmployeur;
    }
}