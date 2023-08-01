package com.Application.Inventory.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

    public String placeOrder(List<OrderVo> orderList) {
        try {
            Long generatedOrderId=commonUtils.generateOrderId();
            for(OrderVo orderVo : orderList){
            OrderEntity orderEntity = OrderEntity.builder()
                    .orderId(generatedOrderId)
                    .productId(orderVo.getProductId())
                    .quantity(orderVo.getQuantity())
                    .customerPhoneNo(orderVo.getCustomerPhoneNo())
                    .customerName(orderVo.getCustomerName())
                    .customerMailId(orderVo.getCustomerMailId())
                    .employeeName(orderVo.getEmployeeName())
                    .employeeId(orderVo.getEmployeeId())
                    .build();
            orderRepository.save(orderEntity);
            }
            return "Success";
        } catch (Exception e) {
            return "Fail";
        }

    }

    
}
