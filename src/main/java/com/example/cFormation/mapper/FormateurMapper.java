package com.example.cFormation.mapper;

import com.example.cFormation.dto.FormateurDTO;
import com.example.cFormation.models.Formateur;
import org.springframework.stereotype.Component;

@Component
public class FormateurMapper {

    public FormateurDTO toDto(Formateur formateur) {
        FormateurDTO dto = new FormateurDTO();
        dto.setId(formateur.getId());
        dto.setNom(formateur.getNom());
        dto.setPrenom(formateur.getPrenom());
        dto.setEmail(formateur.getEmail());
        dto.setTel(formateur.getTel());

        // Gestion des relations
        if (formateur.getEmployeur() != null) {
            dto.setEmployeurId(formateur.getEmployeur().getId());
        }

        return dto;
    }
}