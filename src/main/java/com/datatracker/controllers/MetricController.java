package com.datatracker.controllers;

import com.datatracker.models.Metric;
import com.datatracker.services.MericService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/metric")
@AllArgsConstructor
public class MetricController {
    private final MericService metricService;

    @ResponseBody
    @GetMapping(value = "/name")
    public List<String> getAllMetricNames() {
        return metricService.getAllNames();
    }

    @ResponseBody
    @GetMapping(value = "/name/{metricName}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Metric getMetric(@PathVariable String metricName) {
        return metricService.get(metricName);
    }

    @ResponseBody
    @GetMapping(value = "/rank/{metricName}")
    public int getMetricRank(@PathVariable String metricName) {
        return metricService.getRank(metricName);
    }
}
