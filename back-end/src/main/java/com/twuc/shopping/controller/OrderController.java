package com.twuc.shopping.controller;

import com.twuc.shopping.dto.GoodOrderDto;
import com.twuc.shopping.dto.OrderDto;
import com.twuc.shopping.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

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

    @GetMapping("/orders")
    public ResponseEntity getGoods() {
        List<GoodOrderDto> goodOrderDtos = orderService.getOrders();
        return ResponseEntity.status(HttpStatus.OK).header("Accept", "application/json").body(goodOrderDtos);
    }
}
