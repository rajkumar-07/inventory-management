package com.Application.Inventory.Repositories;

import org.springframework.stereotype.Repository;

import com.Application.Inventory.Entity.OrderEntity;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, Long> {

}
