package com.example.football.dto;

public class PlayersWithMutualTimeDTO {

    private String playerA;
    private String playerB;
    private int totalTimeTogether;

    public PlayersWithMutualTimeDTO(String playera, String playerb, int totalTimeTogether) {
        this.playerA = playerA;

        this.playerB = playerB;

        this.totalTimeTogether = totalTimeTogether;
    }

    public String getPlayerA() {
        return playerA;
    }


    public void setPlayerA(String playerA) {
        this.playerA = playerA;
    }

    public String getPlayerB() {
        return getPlayerB();
    }



    public void setPlayerB(String playerB) {
        this.playerB = playerB;
    }



    public int getTotalTimeTogether() {
        return totalTimeTogether;
    }



    public void setTotalTimeTogether(int totalTimeTogether) {
        this.totalTimeTogether = totalTimeTogether;
    }
}
