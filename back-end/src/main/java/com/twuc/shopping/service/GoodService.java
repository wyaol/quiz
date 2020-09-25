package com.twuc.shopping.service;

import com.twuc.shopping.repository.GoodRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class GoodService {
    @Resource
    GoodRepository goodRepository;
}
