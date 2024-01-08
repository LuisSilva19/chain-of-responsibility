package com.example.dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class ChainOfResponsabilityDto {
    private String name;
    private String document;
    private String age;
}
