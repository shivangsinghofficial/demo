package com.example.demo.repository.developer;

import com.example.demo.domain.Developer;

public class DeveloperMapper {
    public static DeveloperEntity developerEntityMapper(Developer developer) {
        return DeveloperEntity.builder()
                .id(developer.getId())
                .name(developer.getName())
                .phoneNumber(developer.getPhoneNumber())
                .teamId(developer.getTeamId())
                .build();
    }
}
