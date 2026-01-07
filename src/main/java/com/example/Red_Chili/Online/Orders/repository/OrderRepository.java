package com.example.Red_Chili.Online.Orders.repository;

import com.example.Red_Chili.Online.Orders.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<OrderEntity, Long> {

    List<OrderEntity> findByStatus(String status);

}
