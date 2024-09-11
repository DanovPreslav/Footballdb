package com.example.football.controller;

import com.example.football.dto.ParticipationPlayerDTO;
import com.example.football.dto.PlayersWithMutualTimeDTO;
import com.example.football.service.ParticipationPlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public class ParticipationPlayerController {

    @Autowired
    private ParticipationPlayerService participationService;
    @GetMapping("/most-time")
    public List<PlayersWithMutualTimeDTO> showPlayersWithMostMutualTime() {
        return participationService.getPlayersWithMostMutualTime();
    }
    @GetMapping("/all")
    public List<ParticipationPlayerDTO> showAllPlayerParticipations() {
        return participationService.getAllPlayerParticipations();
    }
}
