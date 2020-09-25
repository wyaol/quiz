package com.twuc.shopping.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class GoodOrderDto {
    private String name;
    private Integer price;
    private String unit;
    private Integer num;
}
