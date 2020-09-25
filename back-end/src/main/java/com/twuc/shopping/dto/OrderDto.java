package com.twuc.shopping.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@AllArgsConstructor
@Data
public class OrderDto {
    private Integer goodId;
    private LocalDateTime createTime;
}
