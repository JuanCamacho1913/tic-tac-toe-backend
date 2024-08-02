package com.tic.tac.toe.domain.services.implement;

import com.tic.tac.toe.Persistence.entities.ClubEntity;
import com.tic.tac.toe.Persistence.repositories.IClubRepository;
import com.tic.tac.toe.domain.exceptions.ClubNotFoundException;
import com.tic.tac.toe.domain.services.interfaces.IClubService;
import com.tic.tac.toe.presentation.dtos.Clubs.ClubRequest;
import com.tic.tac.toe.presentation.dtos.Clubs.ClubResponse;
import com.tic.tac.toe.utils.mappers.ClubMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClubServiceImpl implements IClubService {

    private final IClubRepository clubRepository;
    private final ClubMapper clubMapper;

    @Override
    public List<ClubResponse> findAll() {
        List<ClubEntity> clubList = this.clubRepository.findAll();

        return this.clubMapper.getListClub(clubList);
    }

    @Override
    public ClubResponse findById(Long id) {
        ClubEntity club = this.clubRepository.findById(id)
                .orElseThrow(() -> new ClubNotFoundException(String.format("Club whit id %s does not exist", id)));

        return this.clubMapper.getClub(club);
    }

    @Override
    public ClubResponse createClub(ClubRequest clubRequest) {
        ClubEntity club = this.clubMapper.getClubMappers(clubRequest);
        ClubEntity clubCreate = this.clubRepository.save(club);

        return this.clubMapper.getClub(clubCreate);
    }


    @Override
    public ClubResponse updateClub(ClubRequest clubRequest, Long id) {
        ClubEntity club = this.clubRepository.findById(id)
                .orElseThrow(() -> new ClubNotFoundException(String.format("Club whit id %s does not exist", id)));

        ClubEntity clubForUpdate = this.clubMapper.getUpdateClub(clubRequest, club);
        ClubEntity clubUpdate = this.clubRepository.save(clubForUpdate);

        return this.clubMapper.getClub(clubUpdate);
    }

    @Override
    public void deleteClubById(Long id) {
        this.clubRepository.findById(id)
                .orElseThrow(() -> new ClubNotFoundException(String.format("Club whit id %s does not exist", id)));

        this.clubRepository.deleteById(id);
    }
}
