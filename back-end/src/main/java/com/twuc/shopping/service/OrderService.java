package com.twuc.shopping.service;

import com.twuc.shopping.dto.GoodDto;
import com.twuc.shopping.dto.GoodOrderDto;
import com.twuc.shopping.dto.OrderDto;
import com.twuc.shopping.entity.GoodEntity;
import com.twuc.shopping.entity.OrderEntity;
import com.twuc.shopping.repository.GoodRepository;
import com.twuc.shopping.repository.OrderRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

@Service
public class OrderService {
    @Resource
    OrderRepository orderRepository;

    @Resource
    GoodRepository goodRepository;

    private OrderEntity orderDtoToOrderEntity(OrderDto orderDto) {
        return OrderEntity
                .builder()
                .goodId(orderDto.getGoodId())
                .build();
    }

    private OrderDto orderEntityToGoodDto(OrderEntity orderEntity) {
        return new OrderDto(orderEntity.getGoodId());
    }

    public void addOrder(OrderDto orderDto) {
        orderRepository.save(orderDtoToOrderEntity(orderDto));
    }

    public List<GoodOrderDto> getOrders() {
        List<OrderEntity> orderEntities = orderRepository.findAll();
        Map<Integer, Integer> goodOrders = new HashMap<>();
        orderEntities.forEach(orderEntity -> {
            if (goodOrders.containsKey(orderEntity.getGoodId())) {
                goodOrders.put(orderEntity.getGoodId(), goodOrders.get(orderEntity.getGoodId()) + 1);
            } else {
                goodOrders.put(orderEntity.getGoodId(), 1);
            }
        });

        List<GoodOrderDto> goodOrderDtos = new ArrayList<>();

        goodOrders.keySet().forEach(key -> {
            Optional<GoodEntity> res = goodRepository.findById(key);
            if (res.isPresent()) {
                GoodEntity goodEntity = res.get();
                goodOrderDtos.add(new GoodOrderDto(goodEntity.getName(), goodEntity.getPrice(), goodEntity.getUnit(), goodOrders.get(key)));
            }
        });

        return goodOrderDtos;
    }
}
