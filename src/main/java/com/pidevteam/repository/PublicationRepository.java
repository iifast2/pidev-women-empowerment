package com.pidevteam.repository;

import com.pidevteam.entity.Publication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface PublicationRepository extends JpaRepository<Publication, Long > {
  /*  @Query("select p from Publication p  order by  dateCreation desc ")
     List<Publication> newPublication() ;*/
   List<Publication>  findAllByOrderByDateCreationDesc ();
    List<Publication>  findAllByOrderByDateCreationAsc ();

    Long countByTopic(String top) ;
   /* @Query("select count (p) from Publication p where p.topic =:topic")
      newPublication() ;*/
   @Query("select  p from  Publication  p where   p.topic like %:topic% or p.mood like %:mood% or p.location like %:location%  or p.dateCreation =:dateCreation  ")
    List<Publication> filter(@Param("topic") String topic ,@Param("mood") String mood,@Param("location") String location ,@Param("dateCreation") Date dateCreation );
}
