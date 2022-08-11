package com.datatracker.controllers;

import com.datatracker.services.RefreshService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/ticker")
@AllArgsConstructor
public class RefreshController {
    private final RefreshService refreshService;

    @PostMapping(value = "/{tickerName}")
    public void addTicker(@PathVariable String tickerName) {
        refreshService.add(tickerName);
    }
}
