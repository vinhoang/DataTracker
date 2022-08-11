package com.datatracker.models;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.util.Pair;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.LinkedList;

import static com.datatracker.utilities.Constants.periodWindow;

@Data
@RequiredArgsConstructor
public class Metric {
    final LinkedList<Pair<LocalDateTime, BigDecimal>> timeValueSeries = new LinkedList<>(); // act as a deque
    @NonNull
    private String name;

    private void trim(LocalDateTime now) {
        while (!timeValueSeries.isEmpty() && timeValueSeries.getFirst().getFirst().isBefore(now.minus(periodWindow))) {
            timeValueSeries.pollFirst();
        }
    }

    public void trimAndAddTimeValPair(Pair<LocalDateTime, BigDecimal> pair, LocalDateTime now) {
        trim(now);
        timeValueSeries.add(pair);
    }
}
