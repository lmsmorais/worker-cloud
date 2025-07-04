package com.cloud.payroll.entities;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
public class Worker implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;
    private Double dailyIncome;

}
