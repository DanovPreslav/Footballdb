package com.example.football.service;

import com.example.football.dto.MatchDTO;
import com.example.football.dto.TournamentsDTO;
import com.example.football.model.Match;
import com.example.football.repository.MatchRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.security.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class MatchService {

    @Autowired
    private MatchRepository matchRepository;

    @Autowired
    private PlayerService playerService;



    @Autowired
    private TeamService teamService;

    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    public void saveMeets(List<Match> meets) {
        matchRepository.saveAll(meets);
    }

    public List<MatchDTO> getAll() {
        return this.matchRepository.findAll().stream().map(this::converDTO).collect(Collectors.toList());
    }

    public List<TournamentsDTO> getAllTournamentMatches() {
        List<Object[]> allMatchesData = matchRepository.findAllMatchesData();
        List<TournamentsDTO> matches = new ArrayList<>();

        for (Object[] result : allMatchesData) {
            Long id = (Long) result[0];
            String teamAName = (String) result[1];
            Long teamAId = (Long) result[2];
            String teamBName = (String) result[3];
            Long teamBId = (Long) result[4];
            String score = (String) result[5];
            Timestamp date = (Timestamp) result[6];
            LocalDateTime localDate = date.toInstant()
                    .atZone(ZoneId.systemDefault())
                    .toLocalDateTime();

            TournamentsDTO match = new TournamentsDTO(id, localDate, teamAName,  teamBName,teamAId,teamBId, score
                    );
            matches.add(match);
        }

        return matches;
    }



    private MatchDTO converDTO(Match match) {
        return new MatchDTO(
                match.getId(), match.getTeamA().getId(), match.getTeamB().getId(),
                simpleDateFormat.format(match.getDate()),
                match.getScore()
        );
    }

    public Optional<Match> findMeetById(Long matchId) {
        return matchRepository.findById(matchId);
    }


}
