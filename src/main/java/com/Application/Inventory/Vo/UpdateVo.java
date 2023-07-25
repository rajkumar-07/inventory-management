package com.Application.Inventory.Vo;

import lombok.Data;

@Data
public class UpdateVo {
    private Long productId;
    private String name;
    private String description;
    private int quantity;
    private double price;
    private boolean admin;
}
