package com.example.cFormation.mapper;

import com.example.cFormation.dto.ParticipantDTO;
import com.example.cFormation.models.Participant;
import org.springframework.stereotype.Component;

@Component
public class ParticipantMapper {

    public ParticipantDTO toDto(Participant participant) {
        ParticipantDTO dto = new ParticipantDTO();
        dto.setId(participant.getId());
        dto.setNom(participant.getNom());
        dto.setPrenom(participant.getPrenom());
        dto.setEmail(participant.getEmail());
        dto.setTel(participant.getTel());

        // Gestion des relations
        if (participant.getProfile() != null) {
            dto.setProfileId(participant.getProfile().getId());
        }

        if (participant.getStructure() != null) {
            dto.setStructureId(participant.getStructure().getId());
        }

        return dto;
    }
}