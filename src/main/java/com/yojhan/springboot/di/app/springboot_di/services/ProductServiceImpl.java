package com.yojhan.springboot.di.app.springboot_di.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yojhan.springboot.di.app.springboot_di.models.Product;
import com.yojhan.springboot.di.app.springboot_di.repositories.ProductRepository;

@Primary

@Service
public class ProductServiceImpl implements ProductService {
    // @Autowired inyeccion de dependencias mediante atributos
    // @Qualifier("productFoo")
    private ProductRepository repository;

    /*
     * @Value("${config.imp}")
     * private Double imp;
     */
    @Autowired
    private Environment environment;

    /*
     * @Autowired
     * public void setRepository(ProductRepository repository) {
     * this.repository = repository;
     * } se puede hacer inyeccion de dependencias mediante setters
     */
    public ProductServiceImpl(@Qualifier("productRepositoryJson") ProductRepository repository) {
        this.repository = repository;
    }// con el constructor no hace falta colocar el @AutoWired

    @Override
    public List<Product> findAll() {

        return repository.findAll().stream().map(p -> {// separa cada producto p y aplica la logica dentro de lambda
            Double priceImp = p.getPrice() * environment.getProperty("config.imp", Double.class);
            // Product newProduct = new Product(p.getId(), p.getName(),
            // priceImp.longValue());// crea una instancia para
            // Product y asi no se siga
            // multiplicando el price
            Product newProduct = (Product) p.clone(); // dvuelve el clon del original
            newProduct.setPrice(priceImp.longValue());
            // p.setPrice(priceImp.longValue());
            // return p;
            return newProduct;
        }).collect(Collectors.toList()); // con esta logica el map devuelve un stream, entonces con esto se convierte a
                                         // lista
    }

    @Override
    public Product byAllId(Long id) {

        return repository.findById(id);
    }

}
