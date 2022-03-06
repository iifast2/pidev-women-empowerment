package com.women.spring.repository;

import com.women.spring.model.Response;
import com.women.spring.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@RepositoryRestResource(collectionResourceRel = "user", path = "user")
public interface UserRepository extends JpaRepository<User,Long> {
    User getById(UserRepository userRepo);
}
