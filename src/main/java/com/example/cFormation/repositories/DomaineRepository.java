package com.example.cFormation.repositories;
import com.example.cFormation.models.Domaine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DomaineRepository extends JpaRepository<Domaine, Integer> {
}

