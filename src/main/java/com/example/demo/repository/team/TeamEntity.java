package com.example.demo.repository.team;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Builder
@Data
@Document(collection = "team")
public class TeamEntity {
    private String id;
    private String name;
}
