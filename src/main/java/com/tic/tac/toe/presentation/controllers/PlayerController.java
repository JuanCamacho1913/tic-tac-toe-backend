package com.tic.tac.toe.presentation.controllers;

import com.tic.tac.toe.domain.services.implement.PlayerServiceImpl;
import com.tic.tac.toe.presentation.dtos.Players.PlayerRequest;
import com.tic.tac.toe.presentation.dtos.Players.PlayerRequestAssign;
import com.tic.tac.toe.presentation.dtos.Players.PlayerResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/player")
@RequiredArgsConstructor
public class PlayerController {

    private final PlayerServiceImpl playerService;

    @GetMapping("/findAll")
    public ResponseEntity<List<PlayerResponse>> findAll(){
        return new ResponseEntity<>(this.playerService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<PlayerResponse> findById(@PathVariable Long id){
        return new ResponseEntity<>(this.playerService.findById(id), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<PlayerResponse> createPlayer(@RequestBody @Valid PlayerRequest playerRequest){
        return new ResponseEntity<>(this.playerService.createPlayer(playerRequest), HttpStatus.CREATED);
    }

    @PostMapping("/create/assign")
    public ResponseEntity<PlayerResponse> createPlayer(@RequestBody @Valid PlayerRequestAssign playerRequestAssign){
        return new ResponseEntity<>(this.playerService.createPlayer(playerRequestAssign), HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<PlayerResponse> updatePlayer(@RequestBody @Valid PlayerRequest playerRequest, @PathVariable Long id){
        return new ResponseEntity<>(this.playerService.updatePlayer(playerRequest, id), HttpStatus.OK);
    }

    @GetMapping("/find")
    public ResponseEntity<List<PlayerResponse>> findPlayerByName(@RequestParam String name){
        return new ResponseEntity<>(this.playerService.findPlayerByName(name), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deletePlayerById(@PathVariable Long id){
        this.playerService.deletePlayerById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}



