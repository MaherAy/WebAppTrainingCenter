package com.example.cFormation.repositories;

import com.example.cFormation.models.Formation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FormationRepository extends JpaRepository<Formation, Integer> {

    // Méthode 1: Récupère les participants par ID de structure
    @Query("SELECT f FROM Formation f WHERE f.formateur.id = :formateurId")
    List<Formation> findByFormateurId(@Param("formateurId") int formateurId);

    // Méthode 2: Récupère les participants par ID de profil
    @Query("SELECT f FROM Formation f WHERE f.domaine.id = :domaineId")
    List<Formation> findByDomaineId(@Param("domaineId") int domaineId);}

