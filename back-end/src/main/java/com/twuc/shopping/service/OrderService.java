package com.twuc.shopping.service;

import com.twuc.shopping.dto.GoodOrderDto;
import com.twuc.shopping.dto.GoodsOrderItemDto;
import com.twuc.shopping.dto.OrderDto;
import com.twuc.shopping.entity.GoodEntity;
import com.twuc.shopping.entity.OrderEntity;
import com.twuc.shopping.repository.GoodRepository;
import com.twuc.shopping.repository.OrderRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.Instant;
import java.util.*;

@Service
public class OrderService {
    @Resource
    OrderRepository orderRepository;

    @Resource
    GoodRepository goodRepository;

    private List<OrderEntity> orderDtoToOrderEntity(OrderDto orderDto) {
        List<OrderEntity> orderEntities = new ArrayList<>();
        orderDto.getOrder().forEach(goodsBuyDto -> orderEntities.add(OrderEntity.builder()
                .goodId(goodsBuyDto.getGoodsId())
                .goodNum(goodsBuyDto.getGoodsNum())
                .orderId((int) System.currentTimeMillis())
                .build()
        ));
        return orderEntities;
    }

    public void addOrder(OrderDto orderDto) {
        orderDtoToOrderEntity(orderDto).forEach(orderEntity -> orderRepository.save(orderEntity));
    }

    public List<GoodOrderDto> getOrders() {
        List<OrderEntity> orderEntities = orderRepository.findAll();

        Map<Integer, List<OrderEntity>> goodOrders = new HashMap<>(); // key 为orderId
        orderEntities.forEach(orderEntity -> {
            if (goodOrders.containsKey(orderEntity.getOrderId())) {
                goodOrders.get(orderEntity.getOrderId()).add(orderEntity);
            } else {
                goodOrders.put(orderEntity.getOrderId(), new ArrayList<>(Collections.singletonList(orderEntity)));
            }
        });

        List<GoodOrderDto> goodOrderDtos = new ArrayList<>();

        goodOrders.keySet().forEach(key -> {
            List<OrderEntity> orderEntities1 = goodOrders.get(key);
            List<GoodsOrderItemDto> goodOrderItems = new ArrayList<>();
            orderEntities1.forEach(orderEntity -> {
                Optional<GoodEntity> goodEntityOptional = goodRepository.findById(orderEntity.getGoodId());
                if (goodEntityOptional.isPresent()) {
                    GoodEntity goodEntity = goodEntityOptional.get();
                    goodOrderItems.add(new GoodsOrderItemDto(goodEntity.getName(), goodEntity.getPrice(), goodEntity.getUnit(), orderEntity.getGoodNum()));
                }
            });
            goodOrderDtos.add(new GoodOrderDto(key, goodOrderItems));
        });

        return goodOrderDtos;
    }

    public void delOrder(Integer orderId) {
        orderRepository.deleteAllByOrderId(orderId);
    }
}
