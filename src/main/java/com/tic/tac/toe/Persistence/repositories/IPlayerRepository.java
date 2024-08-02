package com.tic.tac.toe.Persistence.repositories;

import com.tic.tac.toe.Persistence.entities.PlayerEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPlayerRepository extends ListCrudRepository<PlayerEntity, Long> {

    @Query("select p from PlayerEntity p where p.name like %:name% or p.lastName like %:name%")
    List<PlayerEntity> findByNameOrLastNameContaining(String name);

    @Query("select p from PlayerEntity p where p.name = :name and p.lastName = :lastName")
    PlayerEntity findByFullName(String name, String lastName);

}
