package com.twuc.shopping.service;

import com.twuc.shopping.repository.OrderRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class OrderService {
    @Resource
    OrderRepository orderRepository;
}
