package com.Application.Inventory.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Application.Inventory.Vo.OrderVo;
import com.Application.Inventory.Service.OrderService;

@RestController
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping("/place-orders")
    public ResponseEntity<Object> placeOrder(@RequestBody List<OrderVo> orderVo) {
        return orderService.placeOrder(orderVo);
    }
}