package com.tic.tac.toe.domain.services.implement;

import com.tic.tac.toe.Persistence.entities.ClubEntity;
import com.tic.tac.toe.Persistence.entities.PlayerEntity;
import com.tic.tac.toe.Persistence.repositories.IClubRepository;
import com.tic.tac.toe.Persistence.repositories.IPlayerRepository;
import com.tic.tac.toe.domain.exceptions.ClubListEmptyException;
import com.tic.tac.toe.domain.exceptions.ClubNotFoundException;
import com.tic.tac.toe.domain.exceptions.PlayerNotFoundException;
import com.tic.tac.toe.domain.services.interfaces.IPlayerService;
import com.tic.tac.toe.presentation.dtos.Players.PlayerRequest;
import com.tic.tac.toe.presentation.dtos.Players.PlayerRequestAssign;
import com.tic.tac.toe.presentation.dtos.Players.PlayerResponse;
import com.tic.tac.toe.utils.mappers.PlayerMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PlayerServiceImpl implements IPlayerService {

    private final IPlayerRepository playerRepository;
    private final PlayerMapper playerMapper;
    private final IClubRepository clubRepository;

    @Override
    public PlayerResponse createPlayer(PlayerRequest playerRequest) {

        PlayerEntity player = this.playerMapper.getPlayer(playerRequest);
        PlayerEntity playerCreate = this.playerRepository.save(player);

        return this.playerMapper.getPlayerResponse(playerCreate);
    }

    @Override
    public PlayerResponse createPlayer(PlayerRequestAssign playerRequestAssign) {

        List<Long> idClubList = playerRequestAssign.idClub();
        List<ClubEntity> clubList = this.clubRepository.findAllByIdIn(idClubList);

        if (clubList.isEmpty()){
            throw new ClubListEmptyException("Club with id %s does not exist");
        }

        PlayerEntity player = this.playerMapper.getPlayer(playerRequestAssign);
        player.setClub(clubList);
        PlayerEntity playerCreated = this.playerRepository.save(player);
        
        return this.playerMapper.getPlayerResponse(playerCreated);
    }

    @Override
    public List<PlayerResponse> findPlayerByName(String name) {

        List<PlayerEntity> playerEntityList = new ArrayList<>();

        if (name.contains(" ")){
            String[] arrayName = name.split(" ");
            String actualName = arrayName[0];
            String actualLastName = arrayName[1];

            PlayerEntity player = this.playerRepository.findByFullName(actualName, actualLastName);
            playerEntityList.add(player);

            return this.playerMapper.getListPlayer(playerEntityList);
        }else {
            playerEntityList = this.playerRepository.findByNameOrLastNameContaining(name);

            return this.playerMapper.getListPlayer(playerEntityList);
        }
    }

    @Override
    public List<PlayerResponse> findAll() {
        List<PlayerEntity> player = this.playerRepository.findAll();

        return this.playerMapper.getListPlayer(player);
    }

    @Override
    public PlayerResponse findById(Long id) {
        PlayerEntity player = this.playerRepository.findById(id)
                .orElseThrow(() -> new PlayerNotFoundException(String.format("Player with id %s does not exist", id)));

        return this.playerMapper.getPlayerResponse(player);
    }

    @Override
    public PlayerResponse updatePlayer(PlayerRequest playerRequest, Long id) {
        PlayerEntity player = this.playerRepository.findById(id)
                .orElseThrow(() -> new PlayerNotFoundException(String.format("Player with id %s does not exist", id)));

        PlayerEntity playerForUpdate = this.playerMapper.getUpdatePlayer(playerRequest, player);
        PlayerEntity playerUpdate = this.playerRepository.save(playerForUpdate);

        return this.playerMapper.getPlayerResponse(playerUpdate);
    }

    @Override
    public void deletePlayerById(Long id) {
        this.playerRepository.findById(id)
                .orElseThrow(() -> new PlayerNotFoundException(String.format("Player with id %s does not exist", id)));

        this.playerRepository.deleteById(id);
    }

}
