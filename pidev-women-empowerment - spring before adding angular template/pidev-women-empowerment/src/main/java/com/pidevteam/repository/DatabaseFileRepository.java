package com.pidevteam.repository;

import com.pidevteam.entity.File;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DatabaseFileRepository extends JpaRepository<File, String> {

}
