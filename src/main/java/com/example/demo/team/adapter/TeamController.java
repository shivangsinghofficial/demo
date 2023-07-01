package com.example.demo.team.adapter;

import com.example.demo.team.application.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/team")
public class TeamController {

    @Autowired
    TeamService teamService;

    TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @PostMapping("/add")
    @ResponseBody
    public CreateTeamResponseDto createTeam(@RequestBody CreateTeamRequestDto createTeamRequestDto) {
        return this.teamService.createTeam(createTeamRequestDto);
    }
}
