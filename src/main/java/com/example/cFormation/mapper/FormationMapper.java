package com.example.cFormation.mapper;

import com.example.cFormation.dto.FormationDTO;
import com.example.cFormation.models.Formation;
import org.springframework.stereotype.Component;

@Component
public class FormationMapper {

    public FormationDTO toDto(Formation formation) {
        FormationDTO dto = new FormationDTO();
        dto.setId(formation.getId());
        dto.setTitre(formation.getTitre());
        dto.setDate(formation.getDate());
        dto.setDuree(formation.getDuree());
        dto.setBudget(formation.getBudget());

        // Gestion des relations
        if (formation.getFormateur() != null) {
            dto.setFormateurId(formation.getFormateur().getId());
        }

        if (formation.getDomaine() != null) {
            dto.setDomaineId(formation.getDomaine().getId());
        }

        return dto;
    }
}