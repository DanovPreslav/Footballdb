package com.example.football.model;

import jakarta.persistence.*;
@Entity
public class ParticipationPlayer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "game_id")
    private Match match;
    @ManyToOne
    @JoinColumn(name = "player_id")
    private Player player;

    private int toMinutes;
    private int fromMinutes;



    public ParticipationPlayer() {
    }

    public ParticipationPlayer(Player player, Match match, int toMinutes, int fromMinutes) {
        this.match = match;
        this.player = player;
        this.toMinutes = toMinutes;
        this.fromMinutes = fromMinutes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Match getMatch() {
        return match;
    }

    public void setMatch(Match match) {
        this.match = match;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public int getToMinutes() {
        return toMinutes;
    }

    public void setToMinutes(int toMinutes) {
        this.toMinutes = toMinutes;
    }

    public int getFromMinutes() {
        return fromMinutes;
    }

    public void setFromMinutes(int fromMinutes) {
        this.fromMinutes = fromMinutes;
    }
}
