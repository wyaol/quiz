package com.twuc.shopping.repository;

import com.twuc.shopping.entity.GoodEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface GoodRepository extends CrudRepository<GoodEntity, Integer> {
    List<GoodEntity> findAll();
}
