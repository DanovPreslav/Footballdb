package com.example.football.matchdetailsdtos;

public class MatchDetail_Dto {


    private Long matchId;
    private TeamADto teamADTO;
    private TeamBDto teamBDTO;
    private String score;

    public MatchDetail_Dto(Long matchId, TeamADto teamADTO, TeamBDto teamBDTO, String score) {
        this.matchId = matchId;
        this.teamADTO = teamADTO;
        this.teamBDTO = teamBDTO;
        this.score = score;
    }

    public Long getMatchId() {
        return matchId;
    }

    public void setMatchId(Long matchId) {
        this.matchId = matchId;
    }

    public TeamADto getTeamADTO() {
        return teamADTO;
    }

    public void setTeamADTO(TeamADto teamADTO) {
        this.teamADTO = teamADTO;
    }

    public TeamBDto getTeamBDTO() {
        return teamBDTO;
    }

    public void setTeamBDTO(TeamBDto teamBDTO) {
        this.teamBDTO = teamBDTO;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }
}
