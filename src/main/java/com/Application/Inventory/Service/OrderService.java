package com.Application.Inventory.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.Application.Inventory.Entity.OrderEntity;
import com.Application.Inventory.Repositories.OrderRepository;
import com.Application.Inventory.Utils.CommonUtils;
import com.Application.Inventory.Vo.OrderVo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class OrderService {

    private final OrderRepository orderRepository;
    private final CommonUtils commonUtils;

    public ResponseEntity<Object> placeOrder(List<OrderVo> orderList) {
        try {
            for(OrderVo orderVo : orderList){
            OrderEntity orderEntity = OrderEntity.builder()
                    .productId(orderVo.getProductId())
                    .quantity(orderVo.getQuantity())
                    .customerPhoneNo(orderVo.getCustomerPhoneNo())
                    .customerName(orderVo.getCustomerName())
                    .customerMailId(orderVo.getCustomerMailId())
                    .employeeName(orderVo.getEmployeeName())
                    .employeeId(orderVo.getEmployeeId())
                    .timestamp(commonUtils.getCurrentTimestamp())
                    .build();
            orderRepository.save(orderEntity);
            }
            return ResponseEntity.status(HttpStatus.OK).body("Success");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.OK).body("Failed");
        }

    }

    
}
