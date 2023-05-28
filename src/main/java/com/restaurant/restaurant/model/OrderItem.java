package com.restaurant.restaurant.model;

import com.restaurant.restaurant.DTO.OrderItemDTO;
import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "order_item")
@Getter
@Setter
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @ManyToOne
    private Menu menu;
    @ManyToOne
    private Order order;
    @Column(name = "quantity")
    private int quantity;
    @Column(name = "price")
    private BigDecimal price;
    public OrderItemDTO orderItemTO(){
        OrderItemDTO orderItemDTO = new OrderItemDTO();
        orderItemDTO.setId(getId());
        orderItemDTO.setMenu(getMenu());
        orderItemDTO.setQuantity(getQuantity());
        orderItemDTO.setPrice(getPrice());
        return orderItemDTO;
    }
}