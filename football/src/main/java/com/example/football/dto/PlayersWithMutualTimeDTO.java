package com.example.football.dto;

public class PlayersWithMutualTimeDTO {

    private String playera;
    private String playerb;
    private int totalTimeTogether;

    public PlayersWithMutualTimeDTO(String playera, String playerb, int totalTimeTogether) {
        this.playera = playera;
        this.playerb = playerb;
        this.totalTimeTogether = totalTimeTogether;
    }

    public String getPlayera() {
        return playera;
    }

    public void setPlayera(String player1) {
        this.playera = playera;
    }

    public String getPlayerb() {
        return getPlayerb();
    }

    public void setPlayerb(String playerb) {
        this.playerb = playerb;
    }

    public int getTotalTimeTogether() {
        return totalTimeTogether;
    }

    public void setTotalTimeTogether(int totalTimeTogether) {
        this.totalTimeTogether = totalTimeTogether;
    }
}
