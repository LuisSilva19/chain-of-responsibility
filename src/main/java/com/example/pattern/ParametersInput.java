package com.example.pattern;

import com.example.dtos.ChainOfResponsibilityRequest;
import com.example.dtos.ChainDTO;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class ParametersInput {
    private ChainDTO chainDTO;
    private ChainOfResponsibilityRequest request;
}
