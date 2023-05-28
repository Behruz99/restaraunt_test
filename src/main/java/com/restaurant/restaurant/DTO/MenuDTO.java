package com.restaurant.restaurant.DTO;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class MenuDTO {
    private Long id;
    private String name;
    private BigDecimal price;
}
