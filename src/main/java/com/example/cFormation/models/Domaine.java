package com.example.cFormation.models;

import jakarta.persistence.*;


@Entity
@Table(name = "domaine")  // Changé de "profile" à "domaine"
public class Domaine {    // Renommé de Profile à Domaine

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, unique = true)
    private String libelle;

    // Constructeurs
    public Domaine() {}  // Renommé

    public Domaine(String libelle) {  // Renommé
        this.libelle = libelle;
    }

    public int getId() {
        return id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
}