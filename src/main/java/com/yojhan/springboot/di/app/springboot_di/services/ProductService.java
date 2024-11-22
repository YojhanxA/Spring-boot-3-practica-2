package com.yojhan.springboot.di.app.springboot_di.services;

import java.util.List;

import com.yojhan.springboot.di.app.springboot_di.models.Product;

public interface ProductService {
    List<Product> findAll();

    Product byAllId(Long id);
}
