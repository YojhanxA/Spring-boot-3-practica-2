package com.yojhan.springboot.di.app.springboot_di.repositories;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Repository;
//import org.springframework.web.context.annotation.RequestScope;
//import org.springframework.web.context.annotation.SessionScope;

import com.yojhan.springboot.di.app.springboot_di.models.Product;

// @RequestScope
// @SessionScope
@Repository("productList")
public class ProductRepositoryImpl implements ProductRepository {
    private List<Product> data;

    public ProductRepositoryImpl() {
        this.data = Arrays.asList(
                new Product(1L, "Memoria corsaril 32", 300L),
                new Product(2L, "Cpu intel core i9", 850L),
                new Product(3L, "Teclado Razer Mini 60%", 18L),
                new Product(4L, "Motherboard Gigabyte", 490L));
    }

    @Override
    public List<Product> findAll() {
        return data;
    }

    @Override
    public Product findById(Long id) {
        // stream() se utiliza concolecciones, listas y asi. el p Representa cada
        // elemento del Stream. En este caso, como el Stream está basado en una lista de
        // objetos de tipo Product, la p representa un objeto Product.
        return data.stream().filter(p -> p.getId().equals(id)).findFirst().orElse(null);// el .orElse se puede cambiar
                                                                                        // por .orElseThrow(), devuelve
                                                                                        // una exception si no encuentra
                                                                                        // el id
    }

}
