package com.example.demo.team.application;

import com.example.demo.developer.application.DeveloperDao;
import com.example.demo.domain.Developer;
import com.example.demo.repository.team.TeamEntity;
import com.example.demo.team.adapter.CreateTeamRequestDto;
import com.example.demo.team.adapter.CreateTeamResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@Service
public class TeamServiceImpl implements TeamService{

    @Autowired
    TeamDao teamDao;

    @Autowired
    DeveloperDao developerDao;

    TeamServiceImpl(TeamDao teamDao, DeveloperDao developerDao) {
        this.teamDao = teamDao;
        this.developerDao = developerDao;
    }

    @Override
    public CreateTeamResponseDto createTeam(CreateTeamRequestDto createTeamRequestDto) {
        try {
            //TODO: Instead of TeamEntity, Team should be returned
            TeamEntity teamEntity = teamDao.addTeam(createTeamRequestDto.getTeam());
            List<Developer> developerList = createTeamRequestDto.getDevelopersList().stream()
                    .map(developer -> {
                        developer.setTeamId(teamEntity.getId());
                        return  developer;
                    }).collect(Collectors.toList());
            developerDao.addDeveloper(developerList);
            developerList.stream().forEach(developer -> callNotificationService(developer.getPhoneNumber()));
            return CreateTeamResponseDto.builder().status("SUCCESS").message("Team successfully added").build();
        } catch (Exception ex) {
            log.error("Exception in addition of team", ex);
            return CreateTeamResponseDto.builder()
                    .status("ERROR")
                    .errorCode("1004").errorMessage("Error in addition of team").build();
        }
    }

    private void callNotificationService(String phoneNumber) {
        RestTemplate restTemplate = new RestTemplate();
        Map req_payload = new HashMap();
        req_payload.put("phone_number", phoneNumber);
        req_payload.put("message", "You are added to the team");
        // Add the String message converter
        restTemplate.getMessageConverters().add(new StringHttpMessageConverter());
        String url = "https://run.mocky.io/v3/fd99c100-f88a-4d70-aaf7-393dbbd5d99f";
        HttpEntity<?> request = new HttpEntity<>(req_payload, null);
        ResponseEntity<String> response = restTemplate.postForEntity(url, request, String.class);
        log.info("Response received: {}", response);
    }
}
