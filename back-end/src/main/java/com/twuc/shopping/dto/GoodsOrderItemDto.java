package com.twuc.shopping.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GoodsOrderItemDto {
    private String name;
    private Integer price;
    private String unit;
    private Integer num;
}
