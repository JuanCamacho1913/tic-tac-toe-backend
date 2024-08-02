package com.tic.tac.toe.domain.services.interfaces;

import com.tic.tac.toe.presentation.dtos.Clubs.ClubRequest;
import com.tic.tac.toe.presentation.dtos.Clubs.ClubResponse;

import java.util.List;

public interface IClubService {

    List<ClubResponse> findAll();

    ClubResponse findById(Long id);

    ClubResponse createClub(ClubRequest clubRequest);

    ClubResponse updateClub(ClubRequest clubRequest, Long id);

    void deleteClubById(Long id);
}
