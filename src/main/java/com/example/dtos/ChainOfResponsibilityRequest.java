package com.example.dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class ChainOfResponsibilityRequest {
    private String team;
    private String league;
    private String region;
    private String name;
    private String document;
    private String age;
}
