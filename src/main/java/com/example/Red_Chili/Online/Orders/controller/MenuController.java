package com.example.Red_Chili.Online.Orders.controller;

import com.example.Red_Chili.Online.Orders.entity.MenuItemEntity;
import com.example.Red_Chili.Online.Orders.repository.MenuRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.Red_Chili.Online.Orders.service.OrderNotifier;
import java.util.List;

@RestController
@RequestMapping("/api/menu")
public class MenuController {

    private final MenuRepository menuRepository;

    public MenuController(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }

    @GetMapping
    public List<MenuItemEntity> getMenu() {
        return menuRepository.findAll();
    }
}
