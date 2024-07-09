package com.batis.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Car {

    private Long id;

    private String carNum;

    private String brand;

    private BigDecimal guidePrice;

    private String produceTime;

    private String carType;

}
