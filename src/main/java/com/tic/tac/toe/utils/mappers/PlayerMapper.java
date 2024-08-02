package com.tic.tac.toe.utils.mappers;

import com.tic.tac.toe.Persistence.entities.PlayerEntity;
import com.tic.tac.toe.presentation.dtos.Players.PlayerRequest;
import com.tic.tac.toe.presentation.dtos.Players.PlayerRequestAssign;
import com.tic.tac.toe.presentation.dtos.Players.PlayerResponse;
import io.micrometer.common.util.StringUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class PlayerMapper {

    private final ClubMapper clubMapper;

    public PlayerEntity getPlayer(PlayerRequest playerRequest){
        PlayerEntity player = new PlayerEntity();
        player.setName(playerRequest.name());
        player.setLastName(playerRequest.lastName());
        player.setPosition(playerRequest.position());
        player.setNationality(playerRequest.nationality());
        player.setBirthday(playerRequest.birthday());
        player.setClub(playerRequest.club());

        return player;
    }

    public PlayerEntity getPlayer(PlayerRequestAssign playerRequestAssign){
        PlayerEntity player = new PlayerEntity();
        player.setName(playerRequestAssign.name());
        player.setLastName(playerRequestAssign.lastName());
        player.setPosition(playerRequestAssign.position());
        player.setNationality(playerRequestAssign.nationality());
        player.setBirthday(playerRequestAssign.birthday());

        return player;
    }

    public PlayerResponse getPlayerResponse(PlayerEntity player){
        return new PlayerResponse(
                player.getId(),
                player.getName(),
                player.getLastName(),
                player.getPosition(),
                player.getNationality(),
                player.getBirthday(),
                player.getClub()
        );
    }

    public List<PlayerResponse> getListPlayer(List<PlayerEntity> player){
        return player.stream()
                .map(p -> new PlayerResponse(
                            p.getId(),
                            p.getName(),
                            p.getLastName(),
                            p.getPosition(),
                            p.getNationality(),
                            p.getBirthday(),
                            p.getClub()
                    ))
                .toList();
    }

    public PlayerEntity getUpdatePlayer(PlayerRequest playerRequest, PlayerEntity player){

        if (StringUtils.isNotEmpty(playerRequest.name())){
            player.setName(playerRequest.name());
        }

        if(StringUtils.isNotEmpty(playerRequest.lastName())){
            player.setLastName(playerRequest.lastName());
        }

        if (StringUtils.isNotEmpty(playerRequest.position())){
            player.setPosition(playerRequest.position());
        }

        if(StringUtils.isNotEmpty(playerRequest.nationality())){
            player.setNationality(playerRequest.nationality());
        }

        if (StringUtils.isNotEmpty(String.valueOf(playerRequest.birthday()))){
            player.setBirthday(playerRequest.birthday());
        }

        if (StringUtils.isNotEmpty(playerRequest.club().toString())){
            player.setClub(playerRequest.club());
        }

        return player;
    }
}
