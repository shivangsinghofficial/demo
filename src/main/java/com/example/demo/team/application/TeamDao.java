package com.example.demo.team.application;

import com.example.demo.domain.Team;
import com.example.demo.repository.team.TeamEntity;

public interface TeamDao {

    TeamEntity addTeam(Team team);
}
