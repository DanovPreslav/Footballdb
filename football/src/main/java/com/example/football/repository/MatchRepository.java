package com.example.football.repository;

import com.example.football.model.Match;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MatchRepository extends JpaRepository<Match, Long> {

    @Query("SELECT m.id, t1.name, t1.id, t2.name, t2.id, m.score, m.date " +
            "FROM Match m " + "JOIN m.teamA t1 " + "JOIN m.teamB t2 " + "ORDER BY m.date DESC")



    List<Object[]> findAllMatchesData();
}
