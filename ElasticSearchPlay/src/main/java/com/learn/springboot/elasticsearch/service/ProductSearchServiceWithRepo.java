package com.learn.springboot.elasticsearch.service;

import com.learn.springboot.elasticsearch.domain.Product;
import com.learn.springboot.elasticsearch.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductSearchServiceWithRepo {

    private ProductRepository productRepository;

    public void createProductIndexBulk(final List<Product> products) {
        productRepository.saveAll(products);
    }

    public void createProductIndex(final Product product) {
        productRepository.save(product);
    }
}
