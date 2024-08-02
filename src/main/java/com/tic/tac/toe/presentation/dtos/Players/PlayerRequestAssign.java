package com.tic.tac.toe.presentation.dtos.Players;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.List;

public record PlayerRequestAssign(
        @NotBlank(message = "Player Name is mandatory")
        String name,
        @NotBlank(message = "Player Last name is mandatory")
        String lastName,
        @NotBlank(message = "Player position is mandatory")
        String position,
        @NotBlank(message = "Player nationality is mandatory")
        String nationality,
        @NotNull(message = "Player birthday is mandatory")
        LocalDate birthday,

        List<Long> idClub
) {
}
