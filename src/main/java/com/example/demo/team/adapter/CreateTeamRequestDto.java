package com.example.demo.team.adapter;

import com.example.demo.domain.Developer;
import com.example.demo.domain.Team;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@JsonIgnoreProperties
@Data
public class CreateTeamRequestDto {
    private Team team;
    private List<Developer> developersList;
}
