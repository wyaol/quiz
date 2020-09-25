package com.twuc.shopping.service;

import com.twuc.shopping.dto.GoodDto;
import com.twuc.shopping.entity.GoodEntity;
import com.twuc.shopping.repository.GoodRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class GoodService {
    @Resource
    GoodRepository goodRepository;

    private GoodEntity goodDtoToGoodEntity(GoodDto goodDto) {
        return GoodEntity
                .builder()
                .imgUrl(goodDto.getImgUrl())
                .price(goodDto.getPrice())
                .unit(goodDto.getUnit())
                .name(goodDto.getName())
                .build();
    }

    private GoodDto goodEntityToGoodDto(GoodEntity goodEntity) {
        return new GoodDto(goodEntity.getName(), goodEntity.getPrice(), goodEntity.getUnit(), goodEntity.getImgUrl());
    }

    public void addGood(GoodDto goodDto) {
        goodRepository.save(goodDtoToGoodEntity(goodDto));
    }

    public List<GoodDto> getGoods() {
         List<GoodDto> goodDtos = new ArrayList<>();
         goodRepository.findAll().forEach(goodEntity -> goodDtos.add(goodEntityToGoodDto(goodEntity)));
         return goodDtos;
    }
}
