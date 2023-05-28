package com.restaurant.restaurant.service;


import com.restaurant.restaurant.DTO.OrderDTO;
import com.restaurant.restaurant.DTO.OrderItemDTO;
import com.restaurant.restaurant.model.Order;
import com.restaurant.restaurant.model.OrderItem;
import com.restaurant.restaurant.repository.OrderItemRepository;
import com.restaurant.restaurant.repository.OrderRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final OrderItemRepository orderItemRepository;

    public OrderService(OrderRepository orderRepository, OrderItemRepository orderItemRepository) {
        this.orderRepository = orderRepository;
        this.orderItemRepository = orderItemRepository;
    }

    public OrderDTO save(OrderDTO orderRequest) {
        Order order = orderRequest.getId() != null ? orderRepository.getReferenceById(orderRequest.getId()) : null;
        if (order == null) {
            order = new Order();
        }
        order.setUsers(orderRequest.getUsers());
        order.setKomissiya(orderRequest.getKomissiya());
        order.setTotalCost(orderRequest.getTotalCost());
        order.setOrderDate(orderRequest.getOrderDate());
        orderRepository.save(order);

        if (!CollectionUtils.isEmpty(orderRequest.getOrderItems())) {
            for (OrderItemDTO orderItemRequest : orderRequest.getOrderItems()) {
                OrderItem orderItem = orderItemRequest.getId() != null ? orderItemRepository.getReferenceById(orderItemRequest.getId()) : null;
                if (orderItem == null) {
                    orderItem = new OrderItem();
                }
                orderItem.setMenu(orderItemRequest.getMenu());
                orderItem.setPrice(orderItemRequest.getPrice());
                orderItem.setQuantity(orderItemRequest.getQuantity());
                orderItem.setOrder(order);
                ArrayList<OrderItem> orderItems = new ArrayList<>();
                orderItems.add(orderItem);
                orderItemRepository.saveAll(orderItems);
            }
        }
        return order.orderTO();
    }

    public List<OrderDTO> getOrderList() {
        List<OrderDTO> orders = new ArrayList<>();
        List<Order> orderList = orderRepository.findAll();
        if (!CollectionUtils.isEmpty(orderList)) {
            for (Order order : orderList) {
                OrderDTO orderDTO = order.orderTO();
                List<OrderItemDTO> orderItemList = new ArrayList<>();
                List<OrderItem> orderItems = orderItemRepository.findAllByOrderId(order.getId());
                if (!CollectionUtils.isEmpty(orderItems)) {
                    for (OrderItem orderItem : orderItems) {
                        orderItemList.add(orderItem.orderItemTO());
                    }
                    orderDTO.setOrderItems(orderItemList);
                }
                orders.add(orderDTO);
            }
        }
        return orders;
    }

    public void delete(Long id) {
        orderRepository.deleteById(id);
    }

    public OrderDTO getOrderDetail(Long id) {
        Order order = orderRepository.getReferenceById(id);
        return order.orderTO();
    }

    public OrderItemDTO saveOrderItem(OrderItemDTO orderItemDTO) {
        OrderItem orderItem = orderItemDTO.getId() != null ? orderItemRepository.getReferenceById(orderItemDTO.getId()): null;
        if (orderItem == null){
            orderItem = new OrderItem();
        }
        orderItem.setMenu(orderItemDTO.getMenu());
        orderItemDTO.setOrder(orderItemDTO.getOrder());
        orderItem.setPrice(orderItemDTO.getPrice());
        orderItem.setQuantity(orderItemDTO.getQuantity());
        orderItemRepository.save(orderItem);
        return orderItem.orderItemTO();
    }
}