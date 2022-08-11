package com.datatracker.services;

import com.datatracker.models.Metric;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;


/**
 * this class simulates a <k,v> db
 * it keeps data for 24h
 */
@AllArgsConstructor
@Service
@Data
public class dbService {
    //TODO: wire this to datatracker.data.repositories.MetricRepository
    private final Map<String, Metric> db = new HashMap<>();

    public void put(String metricName, BigDecimal val) {
        LocalDateTime now = LocalDateTime.now();
        Metric metric = db.computeIfAbsent(metricName, k -> new Metric(metricName));
        metric.trimAndAddTimeValPair(Pair.of(now, val), now);
    }

    public Metric getMetric(String metricName) {
        if (!db.containsKey(metricName)) return null;
        return db.get(metricName);
    }

    public BigDecimal getLastVal(String metricName) {
        Metric metric = getMetric(metricName);
        if (metric == null) return null;
        LinkedList<Pair<LocalDateTime, BigDecimal>> timeValueSeries = metric.getTimeValueSeries();
        if (timeValueSeries.isEmpty()) return null;
        return timeValueSeries.getLast().getSecond();
    }
}
