package com.women.spring.repository;

import com.women.spring.model.Reclamation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReclamationRepo extends JpaRepository<Reclamation, Long> {
}
