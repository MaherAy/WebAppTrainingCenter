package com.example.cFormation.repositories;

import com.example.cFormation.models.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Integer> {

    // Méthode 1: Récupère les participants par ID de structure
    @Query("SELECT u FROM Utilisateur u WHERE u.role.id = :roleId")
    List<Utilisateur> findByRoleId(@Param("roleId") int roleId);


    // Alternative avec nommage conventionnel (sans @Query)
    List<Utilisateur> findByRole_Id(int roleId);
}
