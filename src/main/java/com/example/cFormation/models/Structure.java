package com.example.cFormation.models;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Setter;
import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "structure")
public class Structure {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Setter
    @Getter
    @Column(nullable = false, unique = true)
    private String libelle;

    // Constructeurs
    public Structure() {}

    public Structure(String libelle) {
        this.libelle = libelle;
    }
    @OneToMany(mappedBy = "structure", cascade = CascadeType.ALL, orphanRemoval = true)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<Participant> participants = new ArrayList<>();

    // Méthode utilitaire
    public void addParticipant(Participant participant) {

    }

    public void setId(int idStructure) {
        this.id = idStructure;
    }

    public int getId() {
        return id;
    }
}