package com.tic.tac.toe.Persistence.repositories;

import com.tic.tac.toe.Persistence.entities.ClubEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IClubRepository extends ListCrudRepository<ClubEntity, Long> {

    List<ClubEntity> findAllByIdIn(List<Long> ids);

    @Query("select c from ClubEntity c where c.name = :name and c.country = :country")
    ClubEntity findClubEntity(String name, String country);
}
