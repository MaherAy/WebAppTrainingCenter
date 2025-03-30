package com.example.cFormation.models;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Setter;
import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "profile")
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Setter
    @Getter
    @Column(nullable = false, unique = true)
    private String libelle;

    // Constructeurs
    public Profile() {}

    public Profile(String libelle) {
        this.libelle = libelle;
    }

    @OneToMany(mappedBy = "profile", cascade = CascadeType.ALL, orphanRemoval = true)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<Participant> participants = new ArrayList<>();

    // Méthode utilitaire
    public void addParticipant(Participant participant) {
        participants.add(participant);
        participant.setProfile(this);
    }
}