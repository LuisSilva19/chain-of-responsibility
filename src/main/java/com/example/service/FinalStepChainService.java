package com.example.service;


import com.example.dtos.CustomParameterResponse;
import com.example.pattern.ParametersInput;
import com.example.pattern.StepChain;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class FinalStepChainService implements StepChain<ParametersInput, CustomParameterResponse> {

    private StepChain<ParametersInput, CustomParameterResponse> chain;

    @Override
    public void nextChain(StepChain<ParametersInput, CustomParameterResponse> nextChain) {
        this.chain = nextChain;
    }

    @Override
    public CustomParameterResponse execute(ParametersInput input) {
        log.info("final Step");
        return CustomParameterResponse.builder().ok(true).build();
    }
}
