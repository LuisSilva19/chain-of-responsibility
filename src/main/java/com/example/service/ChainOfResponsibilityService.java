package com.example.service;

import com.example.dtos.ChainDTO;
import com.example.dtos.ChainOfResponsibilityRequest;
import com.example.dtos.CustomParameterResponse;
import com.example.pattern.ChainOfResponsibilityBuilder;
import com.example.pattern.ParametersInput;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ChainOfResponsibilityService {
    private final ValidateStepChainService validateStepChainService;
    private final FunctionChainService functionChainService;
    private final FinalStepChainService finalStepChainService;

    public CustomParameterResponse execute(ChainOfResponsibilityRequest request) {
        var paraInput = createParametersInput(request);
        var chainRules = buildRulesSteps();
        return chainRules.execute(paraInput);
    }

    private ParametersInput createParametersInput(ChainOfResponsibilityRequest request) {
       return ParametersInput.builder()
               .chainDTO(ChainDTO
                       .builder()
                       .team(request.getTeam())
                       .league(request.getLeague())
                       .region(request.getRegion())
                       .build())
               .request(ChainOfResponsibilityRequest
                       .builder()
                       .age(request.getAge())
                       .name(request.getName())
                       .document(request.getDocument())
                       .build())
               .build();
    }

    private ChainOfResponsibilityBuilder<ParametersInput, CustomParameterResponse> buildRulesSteps() {
       return new ChainOfResponsibilityBuilder<ParametersInput, CustomParameterResponse>()
                .init(validateStepChainService)
                .and(functionChainService)
                .addFinalStep(finalStepChainService);
    }
}
