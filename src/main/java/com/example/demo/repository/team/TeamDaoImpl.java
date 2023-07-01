package com.example.demo.repository.team;

import com.example.demo.domain.Team;
import com.example.demo.team.application.TeamDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeamDaoImpl implements TeamDao {

    @Autowired
    TeamRepository teamRepository;

    TeamDaoImpl(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    @Override
    public TeamEntity addTeam(Team team) {
        TeamEntity teamEntity = TeamMapper.teamEntityMapper(team);
        return teamRepository.save(teamEntity);
    }
}
