package com.example.demo.team.adapter;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;

@Builder
@JsonIgnoreProperties
public class CreateTeamResponseDto {
    private String message;
    private String status;
    private String errorCode;
    private String errorMessage;
}
