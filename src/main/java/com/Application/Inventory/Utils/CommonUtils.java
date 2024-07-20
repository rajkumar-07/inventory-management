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
     public Timestamp getCurrentTimestamp(){
         return new Timestamp(System.currentTimeMillis());
     }
}
