package com.tic.tac.toe.Persistence.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "players")
public class PlayerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String name;

    @Column(name = "last_name")
    String lastName;
    String position;
    String nationality;
    LocalDate birthday;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "player_club",joinColumns = @JoinColumn(name = "player_id"), inverseJoinColumns = @JoinColumn(name = "club_id"))
    List<ClubEntity> club;
}
