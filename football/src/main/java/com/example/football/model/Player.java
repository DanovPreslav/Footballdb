package com.example.football.model;

import jakarta.persistence.*;

@Entity
public class Player {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fullName;
    private String position;

    private int teamNumber;


    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team team;

    public Player() {}


    public Player(Long id, String fullName, String position, int teamNumber, Team team) {
        this.id = id;
        this.fullName = fullName;
        this.position = position;
        this.teamNumber = teamNumber;
        this.team = team;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getTeamNumber() {
        return teamNumber;
    }

    public void setTeamNumber(int teamNumber) {
        this.teamNumber = teamNumber;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
}
