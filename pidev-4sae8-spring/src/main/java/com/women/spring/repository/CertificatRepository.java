package com.women.spring.repository;

import com.women.spring.model.Certificat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CertificatRepository extends JpaRepository<Certificat,Long> {
}
