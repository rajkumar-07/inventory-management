package com.Application.Inventory.Entity;

import java.io.Serializable;
import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
@Entity
@AllArgsConstructor
@Table(name = "order_details")
public class OrderEntity implements Serializable{
    
	private static final long serialVersionUID = 1L;
    
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;
	
    private Long productId;
    
    private int quantity;
    
    private String customerName;
    
    private Long customerPhoneNo;
    
    private String customerMailId;
    
    private String employeeName;
    
    private int employeeId;

    private Timestamp timestamp;
    

}
