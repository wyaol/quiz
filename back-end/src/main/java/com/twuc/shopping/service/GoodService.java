package com.twuc.shopping.service;

import com.twuc.shopping.dto.GoodDto;
import com.twuc.shopping.entity.GoodEntity;
import com.twuc.shopping.repository.GoodRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

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

    public void addGood(GoodDto goodDto) {
        goodRepository.save(goodDtoToGoodEntity(goodDto));
    }
}
