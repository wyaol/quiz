package com.twuc.shopping.controller;

import com.twuc.shopping.dto.OrderDto;
import com.twuc.shopping.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

@RestController
public class OrderController {
    @Resource
    OrderService orderService;

    @PostMapping("/orders")
    public ResponseEntity addOrder(HttpServletRequest request) {
        String goodId = request.getParameter("goodId");
        orderService.addOrder(new OrderDto(Integer.valueOf(goodId)));
        return ResponseEntity.status(HttpStatus.CREATED).header("Accept", "application/x-www-form-urlencode").build();
    }
}
