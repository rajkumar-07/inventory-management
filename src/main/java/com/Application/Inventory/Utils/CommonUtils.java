package com.Application.Inventory.Utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.Application.Inventory.Repositories.OrderRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CommonUtils {

    private final OrderRepository orderRepository;
    

    public  Long generateOrderId(){
        return orderRepository.findGreatestOrderId()+1;
     }
}
