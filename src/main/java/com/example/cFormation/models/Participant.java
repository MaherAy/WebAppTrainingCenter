package com.example.cFormation.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
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
    @Transient  // N'est pas persisté en base (calculé dynamiquement)
    public int getIdStructure() {
        return (this.structure != null) ? this.structure.getId() : 0;
    }

    // Méthode pour définir la structure par son ID
    public void setIdStructure(int idStructure) {
        if (this.structure == null) {
            this.structure = new Structure();
        }
        this.structure.setId(idStructure);
    }

}