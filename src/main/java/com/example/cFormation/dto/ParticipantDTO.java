package com.example.cFormation.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data
public class ParticipantDTO {
    private int id;
    private String nom;
    private String prenom;
    private String email;
    private String tel;

    // Au lieu de l'objet complet, on ne garde que l'ID du profile
    private Integer profileId;

    // Pour la structure
    private Integer structureId;

}