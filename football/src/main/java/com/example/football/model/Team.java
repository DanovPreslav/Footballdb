package com.example.football.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Team {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String groupsName;

    private String manager;


    @OneToMany(mappedBy = "team")
    private List<Player> players;

    public List<Player> getPlayers() {
        return players;
    }


    public Team(Long id, String name, String groupsName, String manager, List<Player> players) {
        this.id = id;
        this.name = name;
        this.groupsName = groupsName;
        this.manager = manager;
        this.players = players;
    }


    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public String getGroupsName() {
        return groupsName;
    }


    public void setGroupsName(String groupsName) {
        this.groupsName = groupsName;
     }

      public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;


    }
}
