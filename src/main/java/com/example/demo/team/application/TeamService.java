package com.example.demo.team.application;

import com.example.demo.team.adapter.CreateTeamRequestDto;
import com.example.demo.team.adapter.CreateTeamResponseDto;

public interface TeamService {

    CreateTeamResponseDto createTeam(CreateTeamRequestDto createTeamRequestDto);
}
