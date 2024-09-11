package com.example.football.Init;

import com.example.football.CSVRead.CSVReader;
import com.example.football.model.Match;

import com.example.football.model.ParticipationPlayer;
import com.example.football.model.Player;
import com.example.football.model.Team;
import com.example.football.service.MatchService;
import com.example.football.service.ParticipationPlayerService;
import com.example.football.service.PlayerService;
import com.example.football.service.TeamService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class DataInit {

    @Autowired
    private TeamService teamService;


    @Autowired
    private PlayerService playerService;


    @Autowired
    private MatchService matchService;


    @Autowired
    ParticipationPlayerService participationPlayerService;


    @Autowired
    private CSVReader csvReader;

    @PostConstruct
    public void init() {
        loadData();
    }

    private void loadData() {
        String filepath = "src/main/java/com/academy/server/data";

        List<Team> teams = csvReader.readTeams(filepath + "/teams.csv");
        if (teams != null) {
            teamService.saveTeams(teams);
        }
        List<Player> players = csvReader.readPlayers(filepath + "/players.csv");
        if (players != null) {
            playerService.savePlayers(players);
        }
        List<Match> matches = csvReader.readMatches(filepath + "/matches.csv");
        if (matches != null) {
            matchService.saveMeets(matches);
        }
        List<ParticipationPlayer> playerParticipations = csvReader.readParticipations(filepath + "/records.csv");
        if (playerParticipations != null) {
            participationPlayerService.saveAllParticipations(playerParticipations);
        }

    }
}
