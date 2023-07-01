package com.example.demo.domain;

import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Team {
    private String id;
    @NonNull
    private String name;
}
