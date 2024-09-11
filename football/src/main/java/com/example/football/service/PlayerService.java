package com.example.football.service;

import com.example.football.dto.IndividualPlayerDTO;
import com.example.football.model.Player;
import com.example.football.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class PlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    public void savePlayers(List<Player> players) {
        playerRepository.saveAll(players);
    }

    public List<IndividualPlayerDTO> getAllPlayers() {

        return playerRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    private IndividualPlayerDTO convertToDTO(Player player) {

        return new IndividualPlayerDTO(player.getId(), player.getFullName(), player.getTeamNumber(),
                player.getPosition(), player.getTeam().getId());

    }

    public Optional<Player> findPlayerById(Long playerId) {
        return playerRepository.findById(playerId);
    }
}
