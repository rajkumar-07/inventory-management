package com.Application.Inventory.Vo;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResponseVo {
    private Long productId;
    private String name;
    private String description;
    private int quantity;
    private double price;
}
