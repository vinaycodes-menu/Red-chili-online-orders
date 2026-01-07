package com.example.Red_Chili.Online.Orders.service;

import com.example.Red_Chili.Online.Orders.entity.OrderEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
public class OrderNotifier {

    private final SimpMessagingTemplate messagingTemplate;

    public OrderNotifier(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }

    public void notifyKitchen(OrderEntity order) {
        messagingTemplate.convertAndSend("/topic/orders", order);
    }
}
