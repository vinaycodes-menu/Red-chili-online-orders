package com.example.Red_Chili.Online.Orders.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String items;
    private String status;
    private String customerName;
    private String pickupTime;


    private LocalDateTime createdAt;

    @PrePersist
    void onCreate() {
        this.status = "NEW";
        this.createdAt = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public String getItems() {
        return items;
    }

    public void setItems(String items) {
        this.items = items;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCustomerName(){
        return customerName;
    }
    public void setCustomerName(String customerName){
        this.customerName = customerName;
    }

    public String getPickupTime(){
        return pickupTime;
    }
    public void setPickupTime(String pickupTime){
        this.pickupTime = pickupTime;
    }
}
