package com.example.Red_Chili.Online.Orders.repository;


import com.example.Red_Chili.Online.Orders.entity.MenuItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuRepository extends JpaRepository<MenuItemEntity, Long> {
}