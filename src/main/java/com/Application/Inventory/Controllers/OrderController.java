package com.Application.Inventory.Controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Application.Inventory.Vo.OrderVo;

@RestController
public class OrderController {

    @PostMapping("/place-order")
    public String placeOrder(@RequestBody OrderVo orderVo) {
        return "";
    }
}