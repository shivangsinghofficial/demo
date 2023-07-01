package com.example.demo.repository.team;

import com.example.demo.domain.Team;

public class TeamMapper {
    public static TeamEntity teamEntityMapper(Team team) {
        return TeamEntity.builder()
                .id(team.getId())
                .name(team.getName())
                .build();
    }
}
