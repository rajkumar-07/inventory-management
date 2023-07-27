package com.Application.Inventory.Entity;

import java.security.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "order_details")
public class OrderEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;
    @Id
    private Long productId;
    private int quantity;
    private String customer_name;
    private Long customer_phone_no;
    private Long customer_mail_id;
    private String employee_name;
    private int employee_id;
    @Column(name = "timestamp", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp timestamp;

}
