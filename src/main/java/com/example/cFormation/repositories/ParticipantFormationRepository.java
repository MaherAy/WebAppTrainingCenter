package com.example.cFormation.repositories;

import com.example.cFormation.models.Participant;
import com.example.cFormation.models.Formation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ParticipantFormationRepository extends JpaRepository<Participant, Integer> {

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO participant_formation (participant_id, formation_id) VALUES (:participantId, :formationId)",
            nativeQuery = true)
    void addParticipantToFormation(@Param("participantId") int participantId,
                                   @Param("formationId") int formationId);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM participant_formation WHERE participant_id = :participantId AND formation_id = :formationId",
            nativeQuery = true)
    void removeParticipantFromFormation(@Param("participantId") int participantId,
                                        @Param("formationId") int formationId);
}