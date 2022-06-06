package com.learn.springboot.elasticsearch.service;

import com.learn.springboot.Main;
import com.learn.springboot.elasticsearch.domain.Product;
import org.apache.lucene.document.IntRange;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = Main.class)
class ProductSearchServiceTest {

    @Autowired
    ProductSearchService productSearchService;


    @Test
    void createProductIndexBulk() {
        Assertions.assertNotNull(productSearchService);
        List<Product> products = getProducts();
        List<String> result = productSearchService.createProductIndexBulk(products);
        Assertions.assertNotNull(result);

    }

    private List<Product> getProducts() {
      return IntStream.range(0, 2)
                .mapToObj(ProductSearchServiceTest::applyAsInt)
                .collect(Collectors.toList());
    }

    @Test
    void createProductIndex() {
    }

    private static Product applyAsInt(int value) {
        Product p = new Product();
        p.setId(String.valueOf(value));
        p.setName("welcome".concat(String.valueOf(value)));
        p.setCategory("buisness");
        p.setManufacturer("Levis");
        p.setPrice(200.0);
        p.setQuantity(1000);
        p.setDescription("Checking description");
        return p;
    }

}