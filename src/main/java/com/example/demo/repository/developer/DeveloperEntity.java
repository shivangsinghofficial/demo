package com.example.demo.repository.developer;

import lombok.Builder;
import org.springframework.data.mongodb.core.mapping.Document;

@Builder
@Document(collection = "developer")
public class DeveloperEntity {
    private String id;
    private String teamId;
    private String name;
    private String phoneNumber;
}
