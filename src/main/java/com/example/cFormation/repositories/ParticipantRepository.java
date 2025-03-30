package com.example.cFormation.repositories;

import com.example.cFormation.models.Participant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ParticipantRepository extends JpaRepository<Participant, Integer> {

    // Méthode 1: Récupère les participants par ID de structure
    @Query("SELECT p FROM Participant p WHERE p.structure.id = :structureId")
    List<Participant> findByStructureId(@Param("structureId") int structureId);

    // Méthode 2: Récupère les participants par ID de profil
    @Query("SELECT p FROM Participant p WHERE p.profile.id = :profileId")
    List<Participant> findByProfileId(@Param("profileId") int profileId);

    // Alternative avec nommage conventionnel (sans @Query)
    List<Participant> findByStructure_Id(int structureId);
    List<Participant> findByProfile_Id(int profileId);
}
