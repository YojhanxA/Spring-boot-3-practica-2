package com.yojhan.springboot.di.app.springboot_di.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import com.yojhan.springboot.di.app.springboot_di.models.Product;
import com.yojhan.springboot.di.app.springboot_di.services.ProductService;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/api")
@RestController
public class SomeController {
    // @Autowired aqui recibe la inyeccion en su atributo, pero se puede recibir con
    // un constructor
    private ProductService service;

    public SomeController(ProductService service) {
        this.service = service;
    }// Inyección de dependencias mediante constructor

    @GetMapping
    public List<Product> list() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Product show(@PathVariable Long id) {
        return service.byAllId(id);
    }
}
