package com.example.cFormation.repositories;
import com.example.cFormation.models.Employeur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeurRepository extends JpaRepository<Employeur, Integer> {
}

