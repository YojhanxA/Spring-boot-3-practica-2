package com.yojhan.springboot.di.app.springboot_di;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.io.Resource;

import com.yojhan.springboot.di.app.springboot_di.repositories.ProductRepository;
import com.yojhan.springboot.di.app.springboot_di.repositories.ProductRepositoryJson;

@Configuration
@PropertySources({
                // CONFIGURACION PARA QUE ACEPTE CARACTERES ESPECIALES (VALUE,
                // ENCONDING="UTF-8")
                @PropertySource(value = "classpath:values.properties", encoding = "UTF-8"),

})
public class ValuesConfig {
        @Value("classpath:json/product.json")
        private Resource resource;

        @Bean
        ProductRepository productRepositoryJson() {
                return new ProductRepositoryJson(resource);
        }
}
