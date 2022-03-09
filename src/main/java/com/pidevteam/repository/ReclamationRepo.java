package com.pidevteam.repository;

import com.pidevteam.entity.Reclamation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReclamationRepo extends JpaRepository<Reclamation, Long> {
}
