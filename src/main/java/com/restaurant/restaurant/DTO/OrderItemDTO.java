package com.restaurant.restaurant.DTO;

import com.restaurant.restaurant.model.Menu;
import com.restaurant.restaurant.model.Order;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class OrderItemDTO {
    private Long id;
    private Menu menu;
    private OrderDTO order;
    private int quantity;
    private BigDecimal price;

}
