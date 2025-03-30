package com.example.cFormation.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data
public class FormationDTO {
    private int id;
    private String titre;
    private int date;
    private int duree;
    private float budget;

    // Au lieu de l'objet complet, on ne garde que l'ID du profile
    private Integer formateurId;

    // Pour la structure
    private Integer domaineId;

}