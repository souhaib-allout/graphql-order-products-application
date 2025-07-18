package org.example.graphqlordersmanagment.repositories;

import org.example.graphqlordersmanagment.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
