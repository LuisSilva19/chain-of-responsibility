package com.example.pattern;

public interface StepChain<Input, Response>{
    void nextChain(StepChain<Input, Response> nextChain);
    Response execute(Input input);
}
