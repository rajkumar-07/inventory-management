package com.Application.Inventory.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "product")
public class ProductEntity {
    @Id
    private Long productId;
    private String name;
    private String description;
    private int quantity;
    private double price;
    
}
