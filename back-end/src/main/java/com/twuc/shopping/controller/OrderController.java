package com.twuc.shopping.controller;

import com.twuc.shopping.service.OrderService;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class OrderController {
    @Resource
    OrderService orderService;
}
