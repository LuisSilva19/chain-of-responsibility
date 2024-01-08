package com.example.controller;

import com.example.dtos.ChainOfResponsibilityRequest;
import com.example.service.ChainOfResponsibilityService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController(value = "/price")
@RequiredArgsConstructor
public class PriceController {
    private final ChainOfResponsibilityService chainOfResponsibilityService;

    @GetMapping(path = "/{id}")
    public void getPrice(@PathVariable("id") String productId) {
        log.info("Getting Price details for Product Id {}", productId);
        var result = chainOfResponsibilityService.execute(ChainOfResponsibilityRequest.builder().build());
        log.info(result.toString());
    }
}