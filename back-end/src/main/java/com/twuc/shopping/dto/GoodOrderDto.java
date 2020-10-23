package com.twuc.shopping.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GoodOrderDto {
    private Integer orderId;
    private List<GoodsOrderItemDto> goodsList;
}
