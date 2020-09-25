package com.twuc.shopping.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class GoodDto {
    private Integer id;
    private String name;
    private Integer price;
    private String unit;
    private String imgUrl;

    public GoodDto(String name, Integer price, String unit, String imgUrl) {
        this.name = name;
        this.price = price;
        this.unit = unit;
        this.imgUrl = imgUrl;
    }
}
