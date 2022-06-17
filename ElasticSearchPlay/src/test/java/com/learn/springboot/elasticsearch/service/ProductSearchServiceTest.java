package com.learn.springboot.elasticsearch.service;

import com.learn.springboot.Main;
import com.learn.springboot.elasticsearch.domain.Product;
import com.learn.springboot.EmbededElasticSearchContainer;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.testcontainers.elasticsearch.ElasticsearchContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertTrue;


@Disabled
@Testcontainers
@ExtendWith(SpringExtension.class)
@SpringBootTest( classes = Main.class)
public class ProductSearchServiceTest {

    @Container
    private static ElasticsearchContainer elasticsearchContainer = new EmbededElasticSearchContainer();

    @BeforeAll
    static void setUp() {
        elasticsearchContainer.start();
    }

    @BeforeEach
    void testIsContainerRunning() {
        assertTrue(elasticsearchContainer.isRunning());
    }


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

    @AfterAll
    static void destroy() {
        elasticsearchContainer.stop();
    }

}