package com.example.football.matchdetailsdtos;

import java.util.List;

public class TeamBDto {

    private Long id;
    private String name;
    private List<PlayerDTO> players;

    public TeamBDto(Long id, String name, List<PlayerDTO> players) {
        this.id = id;
        this.name = name;
        this.players = players;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<PlayerDTO> getPlayers() {
        return players;
    }

    public void setPlayers(List<PlayerDTO> players) {
        this.players = players;
    }
}
