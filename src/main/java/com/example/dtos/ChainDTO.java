package com.example.dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class ChainDTO {
    private String team;
    private String league;
    private String region;
}
