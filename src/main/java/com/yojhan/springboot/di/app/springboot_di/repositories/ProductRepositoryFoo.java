package com.yojhan.springboot.di.app.springboot_di.repositories;

import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.yojhan.springboot.di.app.springboot_di.models.Product;

@Repository("productFoo")
public class ProductRepositoryFoo implements ProductRepository {

    @Override
    public List<Product> findAll() {
        return Collections.singletonList(new Product(1L, "Monitor asus 27pg", 12L));
    }

    @Override
    public Product findById(Long id) {
        return new Product(id, "Monitor asus 27pg", 12L);
    }

}
