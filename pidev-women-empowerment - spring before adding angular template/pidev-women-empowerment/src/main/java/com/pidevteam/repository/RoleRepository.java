package com.pidevteam.repository;

import com.pidevteam.entity.Role;
import com.pidevteam.entity.RoleEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(RoleEnum name);
}
