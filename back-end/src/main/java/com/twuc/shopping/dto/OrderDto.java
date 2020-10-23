package com.twuc.shopping.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;

@AllArgsConstructor
@Data
public class OrderDto {
    private ArrayList<GoodsBuyDto> goodsBuyDtos;
}
