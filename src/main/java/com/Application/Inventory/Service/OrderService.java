package com.Application.Inventory.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Application.Inventory.Entity.OrderEntity;
import com.Application.Inventory.Repositories.OrderRepository;
import com.Application.Inventory.Repositories.ProductRepository;
import com.Application.Inventory.Vo.OrderVo;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public String placeOrder(OrderVo orderVo) {
        try {
            OrderEntity orderEntity = OrderEntity.builder()
                    .productId(orderVo.getProductId())
                    .quantity(orderVo.getQuantity())
                    .customer_phone_no(orderVo.getCustomer_phone_no())
                    .customer_name(orderVo.getCustomer_name())
                    .customer_mail_id(orderVo.getCustomer_mail_id())
                    .employee_name(orderVo.getEmployee_name())
                    .employee_id(orderVo.getEmployee_id())
                    .build();
            orderRepository.save(orderEntity);
            return "Success";
        } catch (Exception e) {
            return "Fail";
        }

    }
}
