package com.example.football.service;

import com.example.football.dto.PlayerTeamDTO;
import com.example.football.dto.TeamDTO;
import com.example.football.model.Team;
import com.example.football.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TeamService {


    @Autowired
    private TeamRepository teamRepository;

    public List<TeamDTO> getAll() {
        return teamRepository.findAll()
                .stream()
                .map(this::convertDTO)
                .collect(Collectors.toList());
    }



    public Optional<Team> getTeamById(Long id) {

        return teamRepository.findById(id);
    }




    public void saveTeams(List<Team> teams) {
        teamRepository.saveAll(teams);
    }





    private TeamDTO convertDTO(Team  team) {
        List<PlayerTeamDTO> playerInTeamDTOS = team.getPlayers().stream()
                .map(player -> new PlayerTeamDTO(
                        player.getId(),
                        player.getFullName(),
                        player.getTeamNumber(),
                        player.getPosition()
                ))
                .collect(Collectors.toList());

        return new TeamDTO(
                team.getId(),
                team.getName(),
                team.getManager(),
                team.getGroupsName(),
                playerInTeamDTOS
        );
    }
}
