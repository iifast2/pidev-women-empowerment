package com.pidevteam.repository;

import com.pidevteam.entity.Certificat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CertificatRepository extends JpaRepository<Certificat,Long> {
}
