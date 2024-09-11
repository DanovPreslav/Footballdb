package com.example.football.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;

@Entity
public class Match {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "team_a_id", nullable = false)
    private Team teamA;
    @ManyToOne
    @JoinColumn(name = "team_b_id", nullable = false)
    private Team teamB;
    private Date date;
    private String score;
    private String penaltyScore;


    public Match(Team teamA, Team teamB, Date date, String score, String penaltyScore) {
        this.teamA = teamA;
        this.teamB = teamB;
        this.date = date;
        this.score = score;
        this.penaltyScore = penaltyScore;
    }

    public Match() {
        
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Team getTeamA() {
        return teamA;
    }

    public void setTeamA(Team teamA) {
        this.teamA = teamA;
    }

    public Team getTeamB() {
        return teamB;
    }

    public void setTeamB(Team teamB) {
        this.teamB = teamB;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getPenaltyScore() {
        return penaltyScore;
    }

    public void setPenaltyScore(String penaltyScore) {
        this.penaltyScore = penaltyScore;
    }


}
