package com.example.cFormation.services;

import com.example.cFormation.dto.ParticipantDTO;
import com.example.cFormation.exception.ResourceNotFoundException;
import com.example.cFormation.mapper.ParticipantMapper;
import com.example.cFormation.models.Participant;
import com.example.cFormation.models.Profile;
import com.example.cFormation.models.Structure;
import com.example.cFormation.repositories.ParticipantRepository;
import com.example.cFormation.repositories.ProfileRepository;
import com.example.cFormation.repositories.StructureRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ParticipantService {

    private final ParticipantRepository participantRepository;
    private final ProfileRepository profileRepository;
    private final StructureRepository structureRepository;
    private final ParticipantMapper participantMapper; // Injection du Mapper
    public ParticipantService(ParticipantRepository participantRepository, ProfileRepository profileRepository, StructureRepository structureRepository, ParticipantMapper participantMapper) {
        this.participantRepository = participantRepository;
        this.profileRepository = profileRepository;
        this.structureRepository = structureRepository;
        this.participantMapper = participantMapper;
    }

    public List<Participant> getAllParticipants() {
        return participantRepository.findAll();
    }

    public Optional<Participant> getParticipantById(int id) {
        return participantRepository.findById(id);
    }

    public ParticipantDTO getParticipantDTOById(int id) {
        Participant participant = participantRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Participant non trouvé"));

        return participantMapper.toDto(participant); // Utilisation correcte

    }

    public Participant createParticipant(Participant participant, int profileId, int structureId) {
        Profile profile = profileRepository.findById(profileId)
                .orElseThrow(() -> new RuntimeException("Profile non trouvé"));

        Structure structure = structureRepository.findById(structureId)
                .orElseThrow(() -> new RuntimeException("Structure non trouvée"));

        participant.setProfile(profile);
        participant.setStructure(structure);

        return participantRepository.save(participant);
    }

    public Participant updateParticipant(int id, Participant participantDetails) {
        Participant participant = participantRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Participant non trouvé avec l'ID : " + id));

        participant.setNom(participantDetails.getNom());
        participant.setPrenom(participantDetails.getPrenom());
        participant.setEmail(participantDetails.getEmail());
        participant.setTel(participantDetails.getTel());
        participant.setIdStructure(participantDetails.getIdStructure());

        return participantRepository.save(participant);
    }

    public void deleteParticipant(int id) {
        participantRepository.deleteById(id);
    }

    // Méthode 1: Par structure ID
    public List<Participant> getParticipantsByStructureId(int structureId) {
        // Vérifie d'abord si la structure existe
        structureRepository.findById(structureId)
                .orElseThrow(() ->
                        new EntityNotFoundException("Structure non trouvée avec l'ID: " + structureId));

        return participantRepository.findByStructure_Id(structureId);
    }

    // Méthode 2: Par profil ID
    public List<Participant> getParticipantsByProfileId(int profileId) {
        // Vérifie d'abord si le profil existe
        profileRepository.findById(profileId)
                .orElseThrow(() ->
                        new EntityNotFoundException("Profil non trouvé avec l'ID: " + profileId));

        return participantRepository.findByProfile_Id(profileId);
    }
}