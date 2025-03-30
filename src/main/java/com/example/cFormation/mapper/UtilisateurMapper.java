package com.example.cFormation.mapper;

import com.example.cFormation.dto.UtilisateurDTO;
import com.example.cFormation.models.Utilisateur;
import org.springframework.stereotype.Component;
@Component
public class UtilisateurMapper {
    public UtilisateurDTO toDto(Utilisateur utilisateur) {
            UtilisateurDTO dto = new UtilisateurDTO();
            dto.setId(utilisateur.getId());
            dto.setLogin(utilisateur.getLogin());
            dto.setMotdepasse(utilisateur.getMotdePasse());
            dto.setEmail(utilisateur.getEmail());


            // Gestion des relations
            if (utilisateur.getRole() != null) {
                dto.setRoleId(utilisateur.getRole().getId());
            }

            return dto;
        }

}
