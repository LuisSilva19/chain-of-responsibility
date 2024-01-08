package com.example.pattern;

import lombok.extern.slf4j.Slf4j;

import java.util.Objects;

@Slf4j
public class ChainOfResponsibilityBuilder<Input, Response>{
    private StepChain<Input, Response> head;
    private StepChain<Input, Response> tail;

    public ChainOfResponsibilityBuilder<Input, Response> init(StepChain<Input, Response> step) {
        this.head = step;
        return this;
    }

    public ChainOfResponsibilityBuilder<Input, Response> and(StepChain<Input, Response> step) {
        if(Objects.isNull(head)) {
            return init(step);
        }
        Objects.requireNonNullElseGet(tail, () -> head).nextChain(step);
        this.tail = step;
        return this;
    }

    public ChainOfResponsibilityBuilder<Input, Response> addFinalStep(StepChain<Input, Response> step) {
        if(Objects.nonNull(this.tail)) {
            this.tail.nextChain(step);
            this.tail = step;
        }
        return this;
    }

    public Response execute(Input input) {
        return head.execute(input);
    }

}
