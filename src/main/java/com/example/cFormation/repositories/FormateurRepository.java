package com.example.cFormation.repositories;

import com.example.cFormation.models.Formateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FormateurRepository extends JpaRepository<Formateur, Integer> {

    // Méthode 1: Récupère les participants par ID de structure
    @Query("SELECT f FROM Formateur f WHERE f.employeur.id = :employeurId")
    List<Formateur> findByEmployeurId(@Param("employeurId") int employeurId);



    // Alternative avec nommage conventionnel (sans @Query)
    List<Formateur> findByEmployeur_Id(int employeurId);
}
