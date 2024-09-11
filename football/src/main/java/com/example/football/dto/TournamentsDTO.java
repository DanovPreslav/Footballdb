package com.example.football.dto;

import java.time.LocalDateTime;

public class TournamentsDTO {


    private Long id;
    private LocalDateTime date;

    private String teamAName;


    private String teamBName;

    private Long teamAId;
    private Long teamBId;
    private String score;

    public TournamentsDTO(Long id,LocalDateTime date, String teamAName,String teamBName, Long teamAId,  Long teamBId, String score ) {
        this.id = id;
        this.date = date;
        this.teamAName = teamAName;
        this.teamAId = teamAId;
        this.teamBName = teamBName;
        this.teamBId = teamBId;
        this.score = score;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTeamAName() {
        return teamAName;
    }

    public void setTeamAName(String teamAName) {
        this.teamAName = teamAName;
    }

    public Long getTeamAId() {
        return teamAId;
    }

    public void setTeamAId(Long teamAId) {
        this.teamAId = teamAId;
    }

    public String getTeamBName() {
        return teamBName;
    }

    public void setTeamBName(String teamBName) {
        this.teamBName = teamBName;
    }

    public Long getTeamBId() {
        return teamBId;
    }

    public void setTeamBId(Long teamBId) {
        this.teamBId = teamBId;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}
