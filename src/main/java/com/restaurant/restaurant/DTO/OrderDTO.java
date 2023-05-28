package com.restaurant.restaurant.DTO;

import com.restaurant.restaurant.model.Users;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Getter
@Setter
public class OrderDTO {
    private Long id;
    private Users users;
    private BigDecimal totalCost;
    private BigDecimal komissiya;
    private Date orderDate;
    private List<OrderItemDTO> orderItems;
}
