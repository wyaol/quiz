package com.twuc.shopping.service;

import com.twuc.shopping.dto.OrderDto;
import com.twuc.shopping.entity.OrderEntity;
import com.twuc.shopping.repository.OrderRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class OrderService {
    @Resource
    OrderRepository orderRepository;

    private OrderEntity orderDtoToOrderEntity(OrderDto orderDto) {
        return OrderEntity
                .builder()
                .goodId(orderDto.getGoodId())
                .build();
    }

    public void addOrder(OrderDto orderDto) {
        orderRepository.save(orderDtoToOrderEntity(orderDto));
    }
}
