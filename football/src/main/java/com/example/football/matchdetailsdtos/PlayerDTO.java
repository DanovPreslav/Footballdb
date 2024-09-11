package com.example.football.matchdetailsdtos;

public class PlayerDTO {


    private Long id;


    private String fullName;



    private String position;

    public PlayerDTO(Long id, String fullName, String position) {
        this.id = id;
        this.fullName = fullName;
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

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
