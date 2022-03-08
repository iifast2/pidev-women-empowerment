package com.women.spring.repository;

import com.women.spring.model.ChatReact;
import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChatReactRepository extends JpaRepository<ChatReact, Long> {

}