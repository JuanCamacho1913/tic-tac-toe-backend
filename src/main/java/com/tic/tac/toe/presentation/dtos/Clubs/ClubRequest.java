package com.tic.tac.toe.presentation.dtos.Clubs;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ClubRequest(

        @NotBlank(message = "Club name is mandatory")
        String name,
        @NotBlank(message = "Club country is mandatory")
        String country,
        //@NotNull(message = "Club images is mandatory")
        String images
) {
}
