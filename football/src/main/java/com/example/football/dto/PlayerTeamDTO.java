package com.example.football.dto;

public class PlayerTeamDTO {

    private Long id;
    private String fullName;


    private int teamNumber;

    private String position;


    public PlayerTeamDTO(Long id, String fullName, int teamNumber, String position) {
        this.id = id;
        this.fullName = fullName;
        this.teamNumber = teamNumber;
        this.position = position;
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


    public int getTeamNumber() {
        return teamNumber;
    }


    public void setTeamNumber(int teamNumber) {
        this.teamNumber = teamNumber;
    }


    public String getPosition() {
        return position;
    }


    public void setPosition(String position) {
        this.position = position;
    }


}

