package com.twuc.shopping.controller;

import com.twuc.shopping.dto.GoodOrderDto;
import com.twuc.shopping.dto.OrderDto;
import com.twuc.shopping.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class OrderController {
    @Resource
    OrderService orderService;

    @PostMapping("/orders")
    public ResponseEntity addOrder(@RequestBody OrderDto orderDto) {
        orderService.addOrder(orderDto);
        return ResponseEntity.status(HttpStatus.CREATED).header("Accept", "application/x-www-form-urlencode").build();
    }

    @GetMapping("/orders")
    public ResponseEntity getOrders() {
        List<GoodOrderDto> goodOrderDtos = orderService.getOrders();
        return ResponseEntity.status(HttpStatus.OK).header("Accept", "application/json").body(goodOrderDtos);
    }

    @DeleteMapping("/orders")
    public ResponseEntity delOrder(@RequestBody Integer orderId) {
        orderService.delOrder(orderId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).header("Accept", "application/x-www-form-urlencode").build();
    }
}
