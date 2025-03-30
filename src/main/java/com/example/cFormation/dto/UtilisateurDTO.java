package com.example.cFormation.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data
public class UtilisateurDTO {
    private int id;
    private String Login;
    private String Motdepasse;
    private String email;


    // Au lieu de l'objet complet, on ne garde que l'ID du profile
    private Integer roleId;

}