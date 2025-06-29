package org.example.graphqlordersmanagment.repositories;

import org.example.graphqlordersmanagment.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findProductByTitleContaining(String name);
}
