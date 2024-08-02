package com.tic.tac.toe.domain.services.interfaces;

import com.tic.tac.toe.presentation.dtos.Players.PlayerRequest;
import com.tic.tac.toe.presentation.dtos.Players.PlayerRequestAssign;
import com.tic.tac.toe.presentation.dtos.Players.PlayerResponse;

import java.util.List;

public interface IPlayerService {

    PlayerResponse createPlayer(PlayerRequest playerRequest);

    PlayerResponse createPlayer(PlayerRequestAssign playerRequestAssign);

    List<PlayerResponse> findPlayerByName(String name);

    List<PlayerResponse> findAll();

    PlayerResponse findById(Long id);

    PlayerResponse updatePlayer(PlayerRequest playerRequest, Long id);

    void deletePlayerById(Long id);


}
