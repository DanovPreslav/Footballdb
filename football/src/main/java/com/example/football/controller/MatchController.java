package com.example.football.controller;

import com.example.football.dto.MatchDTO;
import com.example.football.dto.TournamentsDTO;
import com.example.football.service.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/matches")
public class MatchController {

    @Autowired
    private MatchService matchService;

    @GetMapping("/all")
    public List<MatchDTO> showAllMeets() {
        return matchService.getAll();
    }



    @GetMapping("/tournament-data")
    public List<TournamentsDTO> showAllTournamentMatches() {
        return  matchService.getAllTournamentMatches();
    }

}
