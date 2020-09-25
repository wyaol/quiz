package com.twuc.shopping.controller;

import com.twuc.shopping.service.GoodService;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class GoodController {
    @Resource
    GoodService goodService;
}
