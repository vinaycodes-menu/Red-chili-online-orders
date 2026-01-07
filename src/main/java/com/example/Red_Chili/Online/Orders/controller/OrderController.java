package com.example.Red_Chili.Online.Orders.controller;

import com.example.Red_Chili.Online.Orders.entity.OrderEntity;
import com.example.Red_Chili.Online.Orders.repository.OrderRepository;
import org.springframework.web.bind.annotation.*;
import com.example.Red_Chili.Online.Orders.service.OrderNotifier;
import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderRepository orderRepository;
    private final OrderNotifier notifier;

    public OrderController(OrderRepository orderRepository, OrderNotifier notifier) {
        this.orderRepository = orderRepository;
        this.notifier = notifier;
    }

    @PostMapping
    public OrderEntity createOrder(@RequestBody String items) {
        OrderEntity order = new OrderEntity();
        order.setItems(items);

        OrderEntity saved = orderRepository.save(order);
        notifier.notifyKitchen(saved); // 🔔 beep trigger
        return saved;
    }

    @GetMapping("/new")
    public List<OrderEntity> newOrders() {
        return orderRepository.findByStatus("NEW");
    }

    @PutMapping("/{id}/accept")
    public void accept(@PathVariable Long id) {
        OrderEntity order = orderRepository.findById(id).orElseThrow();
        order.setStatus("ACCEPTED");
        orderRepository.save(order);
    }
}

