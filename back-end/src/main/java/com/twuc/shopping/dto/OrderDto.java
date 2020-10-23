package com.twuc.shopping.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderDto {
    private Integer orderId;
    private ArrayList<GoodsBuyDto> order;
}
