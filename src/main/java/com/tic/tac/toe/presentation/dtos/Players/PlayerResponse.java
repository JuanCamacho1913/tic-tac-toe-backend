package com.tic.tac.toe.presentation.dtos.Players;

import com.tic.tac.toe.Persistence.entities.ClubEntity;

import java.time.LocalDate;
import java.util.List;

public record PlayerResponse(
        Long id,
        String name,
        String lastName,
        String position,
        String nationality,
        LocalDate birthday,
        List<ClubEntity> club
){
}
