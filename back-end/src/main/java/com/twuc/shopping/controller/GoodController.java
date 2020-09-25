package com.twuc.shopping.controller;

import com.twuc.shopping.dto.GoodDto;
import com.twuc.shopping.service.GoodService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class GoodController {
    @Resource
    GoodService goodService;

    @PostMapping("/goods")
    public ResponseEntity addGood(@RequestBody GoodDto goodDto) {
        goodService.addGood(goodDto);
        return ResponseEntity.status(HttpStatus.CREATED).header("Accept", "application/json").build();
    }

    @GetMapping("/goods")
    public ResponseEntity getGoods() {
        List<GoodDto> goodDtos = goodService.getGoods();
        return ResponseEntity.status(HttpStatus.OK).header("Accept", "application/json").body(goodDtos);
    }
}
