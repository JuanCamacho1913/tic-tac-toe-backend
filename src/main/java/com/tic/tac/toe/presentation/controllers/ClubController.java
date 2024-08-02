package com.tic.tac.toe.presentation.controllers;

import com.tic.tac.toe.domain.services.implement.ClubServiceImpl;
import com.tic.tac.toe.presentation.dtos.Clubs.ClubRequest;
import com.tic.tac.toe.presentation.dtos.Clubs.ClubResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/club")
@RequiredArgsConstructor
public class ClubController {

    private final ClubServiceImpl clubService;

    @GetMapping("/findAll")
    public ResponseEntity<List<ClubResponse>> findAll(){
        return new ResponseEntity<>(this.clubService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<ClubResponse> findById(@PathVariable Long id){
        return new ResponseEntity<>(this.clubService.findById(id), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<ClubResponse> createClub(@RequestBody @Valid ClubRequest clubRequest){
        return new ResponseEntity<>(this.clubService.createClub(clubRequest), HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ClubResponse> updateClub(@RequestBody @Valid ClubRequest clubRequest, @PathVariable Long id){
        return new ResponseEntity<>(this.clubService.updateClub(clubRequest, id), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteClubById(@PathVariable Long id){
        this.clubService.deleteClubById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}








