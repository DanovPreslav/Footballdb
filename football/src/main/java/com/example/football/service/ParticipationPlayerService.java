package com.example.football.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.football.dto.ParticipationPlayerDTO;
import com.example.football.dto.PlayersWithMutualTimeDTO;
import com.example.football.model.ParticipationPlayer;
import com.example.football.repository.ParticipationPlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
@Service
public class ParticipationPlayerService {



    @Autowired
    private ParticipationPlayerRepository participationPlayerRepository;

    public void saveAllParticipation(List<ParticipationPlayer> participationPlayers) {
        participationPlayerRepository
                .saveAll(participationPlayers);
    }

    public List<PlayersWithMutualTimeDTO> getPlayersWithMostMutualTime() {
        List<Object[]> results = participationPlayerRepository.findPlayersWithMutualTimeTogether();
        return mapToPlayersWithMostMutualTimeDTO(results);
    }

    public List<ParticipationPlayerDTO> getAllPlayerParticipations() {
        return participationPlayerRepository.findAll().stream()
                .map(this::mapToPlayerParticipationDTO).collect(Collectors.toList());
    }

    private List<PlayersWithMutualTimeDTO> mapToPlayersWithMostMutualTimeDTO(List<Object[]> results) {
        List<PlayersWithMutualTimeDTO> resultDTOs = new ArrayList<>();
        for (Object[] result : results) {
            String player1 = (String) result[0];
            String player2 = (String) result[1];
            BigDecimal bigDecimal = (BigDecimal) result[2];
            int totalTimeTogether = bigDecimal.intValue();
            resultDTOs.add(new PlayersWithMutualTimeDTO(player1, player2, totalTimeTogether));
        }
        return resultDTOs;
    }

    private ParticipationPlayerDTO mapToPlayerParticipationDTO(ParticipationPlayer participationPlayer) {
        return new ParticipationPlayerDTO(
                participationPlayer.getId(), participationPlayer.getPlayer().getId(), participationPlayer.getMatch().getId(),
                participationPlayer.getFromMinutes(),
                participationPlayer.getToMinutes()
        );
    }


}
