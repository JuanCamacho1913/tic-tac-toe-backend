package com.tic.tac.toe.utils.mappers;

import com.tic.tac.toe.Persistence.entities.ClubEntity;
import com.tic.tac.toe.presentation.dtos.Clubs.ClubRequest;
import com.tic.tac.toe.presentation.dtos.Clubs.ClubResponse;
import io.micrometer.common.util.StringUtils;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ClubMapper {

    public List<ClubResponse> getListClub(List<ClubEntity> clubEntities) {
        return clubEntities.stream()
                .map(p -> new ClubResponse(
                        p.getId(),
                        p.getName(),
                        p.getCountry(),
                        p.getImages()
                ))
                .toList();
    }

    public ClubResponse getClub(ClubEntity club){
        return new ClubResponse(
                club.getId(),
                club.getName(),
                club.getCountry(),
                club.getImages()
        );
    }

    public ClubEntity getClubMappers(ClubRequest clubRequest){
        ClubEntity club = new ClubEntity();
        club.setName(clubRequest.name());
        club.setCountry(clubRequest.country());

        return club;
    }

    public ClubEntity getUpdateClub(ClubRequest clubRequest, ClubEntity club){
        if (StringUtils.isNotEmpty(clubRequest.name())){
            club.setName(clubRequest.name());
        }

        if (StringUtils.isNotEmpty(clubRequest.country())){
            club.setCountry(clubRequest.country());
        }

        return club;
    }

}
