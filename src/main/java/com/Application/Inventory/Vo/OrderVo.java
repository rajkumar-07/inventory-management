package com.Application.Inventory.Vo;

import java.security.Timestamp;

import lombok.Data;

@Data
public class OrderVo {
    private Long productId;
    private String customer_name;
    private Long customer_phone_no;
    private Long customer_mail_id;
    private String employee_name;
    private int employee_id;
    private Timestamp timestamp;
    private int quantity;
}
