package com.twuc.shopping.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "goods")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class GoodEntity {
    @Id
    @GeneratedValue
    private Integer id;

    private String name;
    private Integer price;
    private String unit;
    private String imgUrl;
}
