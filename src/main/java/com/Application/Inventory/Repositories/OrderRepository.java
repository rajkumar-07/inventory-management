package com.Application.Inventory.Repositories;

import org.springframework.stereotype.Repository;

import com.Application.Inventory.Entity.OrderEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, Long> {

    @Query("SELECT MAX(o.orderId) FROM OrderEntity o")
    Long findGreatestOrderId();
    
}
