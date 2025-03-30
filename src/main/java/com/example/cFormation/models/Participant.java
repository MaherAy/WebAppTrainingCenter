package com.example.cFormation.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Participant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nom;
    private String prenom;
    private String email;
    private String tel;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "profile_id")
    private Profile profile;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "structure_id")
    private Structure structure;

    @ManyToMany
    @JoinTable(
            name = "participant_formation",
            joinColumns = @JoinColumn(name = "participant_id"),
            inverseJoinColumns = @JoinColumn(name = "formation_id"))
    private Set<Formation> formations;

    @Transient
    public int getIdStructure() {
        return (this.structure != null) ? this.structure.getId() : 0;
    }

    public void setIdStructure(int idStructure) {
        if (this.structure == null) {
            this.structure = new Structure();
        }
        this.structure.setId(idStructure);
    }
}