package com.Application.Inventory.Vo;

import java.security.Timestamp;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class OrderVo {
    private Long productId;
    private String customerName;
    @Size(min = 10, max = 10)
    private Long customerPhoneNo;
    @Email
    private String customerMailId;
    private String employeeName;
    private int employeeId;
    private int quantity;
}
