package org.example.graphqlordersmanagment.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.graphqlordersmanagment.models.Product;
import org.example.graphqlordersmanagment.repositories.ProductRepository;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequiredArgsConstructor
@Slf4j
public class ProductController {

    private final ProductRepository productRepository;

    @QueryMapping
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @QueryMapping
    public List<Product> getProductsByTitle(@Argument("input") String name) {
        return productRepository.findProductByTitleContaining(name);
    }
    @MutationMapping
    public Product createProduct(@Valid @Argument("input") Product product) {
        log.info(product.toString());
        return productRepository.save(product);
    }


}
