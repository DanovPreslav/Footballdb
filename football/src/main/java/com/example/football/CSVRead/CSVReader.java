package com.example.football.CSVRead;

import com.example.football.Impl.ValidatorInput;
import com.example.football.model.Match;
import com.example.football.model.ParticipationPlayer;
import com.example.football.model.Player;
import com.example.football.model.Team;
import com.example.football.service.MatchService;
import com.example.football.service.PlayerService;
import com.example.football.service.TeamService;
import com.example.football.utils.DateParser;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CSVReader {



    @Autowired
    private ValidatorInput validatorInput;
    @Autowired
    private TeamService teamService;
    @Autowired
    private PlayerService playerService;
    @Autowired
    private MatchService matchService;
    @Autowired
    private DateParser dateParser;
    public List<Team> readTeams(String filepath){
        List<Team> teams = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filepath))) {

            int lineNum = 0;
            String line;

            if ((line = br.readLine()) == null) {
                System.out.println("Teams file is empty");
                return teams;
            }

            while ((line = br.readLine()) != null) {
                boolean validated = ValidatorInput.validateTeam(line, lineNum);

                if (validated) {
                    String[] data = line.split(",");
                    String country = data[1].trim();
                    String manager = data[2].trim();
                    String group = data[3].trim();

                    Team team = new Team(country, manager, group);
                    teams.add(team);
                } else {
                    System.out.println("Please try again with valid data");
                    return null;
                }

                lineNum++;
            }
        } catch (FileNotFoundException fileNotFoundException) {
            System.out.println(fileNotFoundException.getMessage() + "Error");

        } catch (IOException e) {
            System.out.println(e.getMessage() + "Error");

        }

        return teams;
    }

    public List<Player> readPlayers(String filepath) {
        List<Player> players = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filepath))) {
            String line;
            int lineNum = 0;

            if ((line = br.readLine()) == null) {
                System.out.println("Players file is empty");
                return players;
            }

            while ((line = br.readLine()) != null) {
                boolean validated = validatorInput.validatePlayer(line, lineNum);
                String[] data = line.split(",");

                if (validated) {
                    int teamNumber = Integer.parseInt(data[1]);
                    String position = data[2];
                    String name = data[3];
                    Long teamId = Long.parseLong(data[4]);
                    Team team = teamService.getTeamById(teamId).get();
                    Player player = new Player(name, teamNumber, position, team);
                    players.add(player);
                } else {
                    System.out.println("Please try again with valid data");
                    return null;
                }

                lineNum++;
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return players;
    }

    public List<Match> readMatches(String path) {
        List<Match> meets = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            int lineNum = 0;

            if ((line = br.readLine()) == null) {
                System.out.println("Matches file is empty");
                return meets;
            }

            while ((line = br.readLine()) != null) {
                boolean validated = validatorInput.validateMatch(line, lineNum);

                if (validated) {
                    String[] data = line.split(",");
                    long teamAId = Long.parseLong(data[1]);
                    long teamBId = Long.parseLong(data[2]);

                    Team teamA = teamService.getTeamById(teamAId).get();
                    Team teamB = teamService.getTeamById(teamBId).get();
                    String format = "MM/dd/yyyy";

                    Date date = dateParser.parseDateFromMDY(data[3], format);

                    String result = data[4];

                    Match match = new Match(teamA, teamB, date, result);
                    match.add(match);
                }


                lineNum++;
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return meets;
    }

    public List<ParticipationPlayer> readParticipations(String filepath) {
        List<ParticipationPlayer> playerParticipations = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filepath))) {
            String line;
            int lineNum = 0;

            if ((line = br.readLine()) == null) {
                System.out.println("records file is empty");
                return playerParticipations;
            }

            while ((line = br.readLine()) != null) {
                boolean validated = ValidatorInput.validateParticipation(line, lineNum);

                if (validated) {
                    String[] data = line.split(",");
                    Long playerId = Long.parseLong(data[1]);
                    Player player = playerService.findPlayerById(playerId).get();

                    Long meetId = Long.parseLong(data[2]);

                    Match meet = matchService.findMeetById(meetId).get();

                    int fromMin = Integer.parseInt(data[3]);


                    int toMin;

                    if (data[4].equals("NULL")) {
                        toMin = 90;
                    } else {
                        toMin = Integer.parseInt(data[4]);
                    }

                    ParticipationPlayer participationPlayer = new ParticipationPlayer(
                            player,
                            meet,
                            fromMin,
                            toMin
                    );

                    playerParticipations.add(participationPlayer);
                }

                lineNum++;
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return playerParticipations;
    }
}

