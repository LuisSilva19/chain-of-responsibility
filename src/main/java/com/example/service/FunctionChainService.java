package com.example.service;

import com.example.dtos.CustomParameterResponse;
import com.example.pattern.ParametersInput;
import com.example.pattern.StepChain;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class FunctionChainService implements StepChain<ParametersInput, CustomParameterResponse> {

    private StepChain<ParametersInput, CustomParameterResponse> chain;

    @Override
    public void nextChain(StepChain<ParametersInput, CustomParameterResponse> nextChain) {
        this.chain = nextChain;
    }

    @Override
    public CustomParameterResponse execute(ParametersInput input) {
       log.info("function Step");
        return chain.execute(input);
    }
}
