package com.restaurant.restaurant.web.res;

import com.restaurant.restaurant.DTO.OrderDTO;
import com.restaurant.restaurant.DTO.OrderItemDTO;
import com.restaurant.restaurant.repository.OrderItemRepository;
import com.restaurant.restaurant.repository.OrderRepository;
import com.restaurant.restaurant.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class OrderResource {
    private final OrderService orderService;
    private final OrderRepository orderRepository;
    private final OrderItemRepository orderItemRepository;


    @PostMapping("/order")
    public ResponseEntity<OrderDTO> create(@RequestBody OrderDTO orderDTO) {
        OrderDTO order1 = orderService.save(orderDTO);
        return ResponseEntity.ok(order1);
    }

    @PutMapping("/order")
    public ResponseEntity<OrderDTO> update(@RequestBody OrderDTO orderDTO) {
        OrderDTO order = orderService.save(orderDTO);
        return ResponseEntity.ok(order);
    }

    @GetMapping("/order/list")
    public ResponseEntity<List<OrderDTO>> getAll() {
        List<OrderDTO> orderList = orderService.getOrderList();
        return ResponseEntity.ok(orderList);
    }

    @GetMapping("/order/{id}")
    public ResponseEntity<OrderDTO> getUserDetails(@PathVariable Long id) {
        if (!orderRepository.existsById(id)) {
            throw new RuntimeException("order not found");
        }
        OrderDTO orderDTO = orderService.getOrderDetail(id);
        return ResponseEntity.ok(orderDTO);
    }

    @DeleteMapping("/order/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        if (!orderRepository.existsById(id)) {
            throw new RuntimeException("order not found");
        }
        orderService.delete(id);
        return ResponseEntity.ok("order deleted");
    }

    @PostMapping("/order-item")
    public ResponseEntity<OrderItemDTO> createOrderItem(@RequestBody OrderItemDTO orderItemDTO) {
        if (orderItemDTO == null || orderItemDTO.getOrder() == null || orderItemDTO.getOrder().getId() == null) {
            throw new RuntimeException("Order not found");
        }
        if (!orderRepository.existsById(orderItemDTO.getOrder().getId())) {
            throw new RuntimeException("order not found");
        }
//        if (orderItemDTO.getId() == null || !orderItemRepository.existsById(orderItemDTO.getId())) {
//            throw new RuntimeException("order not found");
//        } PUT holatida

        OrderItemDTO orderItem = orderService.saveOrderItem(orderItemDTO);
        return ResponseEntity.ok(orderItem);
    }
    @PutMapping("/order-item")
    public ResponseEntity<OrderItemDTO> updateOrderItem(@RequestBody OrderItemDTO orderItemDTO) {
        if (orderItemDTO == null || orderItemDTO.getOrder() == null || orderItemDTO.getOrder().getId() == null) {
            throw new RuntimeException("Order not found");
        }
        if (!orderRepository.existsById(orderItemDTO.getOrder().getId())) {
            throw new RuntimeException("order not found");
        }
        if (orderItemDTO.getId() == null || !orderItemRepository.existsById(orderItemDTO.getId())) {
            throw new RuntimeException("order not found");
        }

        OrderItemDTO orderItem = orderService.saveOrderItem(orderItemDTO);
        return ResponseEntity.ok(orderItem);
    }
}

