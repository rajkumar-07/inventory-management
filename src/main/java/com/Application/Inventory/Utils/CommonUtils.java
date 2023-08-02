package com.Application.Inventory.Utils;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

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

     public Timestamp getTimestamp(){
            Date currentDate = new Date();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String formattedDate = dateFormat.format(currentDate);
            Timestamp timestamp = Timestamp.valueOf(formattedDate);
        return timestamp;
     }
}
