package com.datatracker.services;

import com.datatracker.models.Metric;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@AllArgsConstructor
@Service
/**
 * this service is used for
 *
 */
public class MericService {

    private final dbService dbservice;

    public List<String> getAllNames() {
        List<String> names = new ArrayList<>(dbservice.getDb().keySet());
        Collections.sort(names);
        return names;
    }

    public Metric get(String name) {
        return dbservice.getMetric(name);
    }


    public int getRank(String metricName) {
        //TODO: 
        //  1. Iterate through all metric. 
        //  2. Calculate standar dev 
        //  3. rank them 
        //  4. return the rank for the given metric 
        //  5. Improvement: This is repeated work, 
        //     so use a data-structure to keep and update the ranking (RankingService that keep a TreeMap?)
        return -1;
    }
}
