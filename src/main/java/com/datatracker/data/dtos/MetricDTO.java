package com.datatracker.data.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "metric")
public class MetricDTO {
    @Id
    private String name;
}
