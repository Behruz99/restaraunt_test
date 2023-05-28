package com.restaurant.restaurant.model;

import com.restaurant.restaurant.DTO.OrderDTO;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "orders")
@Getter
@Setter

public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Users users;
    @Column(name = "total_cost")
    private BigDecimal totalCost;
    @Column(name = "komissiya")
    private BigDecimal komissiya;
    @Column(name = "order_date")
    private Date orderDate;
//    @OneToMany
//    private List<OrderItem> orderItems;

    public OrderDTO orderTO() {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setId(getId());
        orderDTO.setUsers(getUsers());
        orderDTO.setTotalCost(getTotalCost());
        orderDTO.setKomissiya(getKomissiya());
        orderDTO.setOrderDate(getOrderDate());
//        if (!CollectionUtils.isEmpty(getOrderItems())) {
//            List<OrderItemDTO> orderItems = new ArrayList<>();
//            for (OrderItem orderItem: getOrderItems()) {
//                orderItems.add(orderItem.orderItemTO());
//            }
//            orderDTO.setOrderItems(orderItems);
//        }
        return orderDTO;
    }
}
