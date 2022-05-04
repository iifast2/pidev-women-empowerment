package com.pidevteam.repository;

import com.pidevteam.entity.Publicity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PublicityRepository extends JpaRepository<Publicity, Long > {
}
