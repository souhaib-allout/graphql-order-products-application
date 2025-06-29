package org.example.graphqlordersmanagment.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.graphqlordersmanagment.dtos.CustomResponse;
import org.example.graphqlordersmanagment.models.Order;
import org.example.graphqlordersmanagment.models.Product;
import org.example.graphqlordersmanagment.models.User;
import org.example.graphqlordersmanagment.repositories.OrderRepository;
import org.example.graphqlordersmanagment.repositories.ProductRepository;
import org.example.graphqlordersmanagment.repositories.UserRepository;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
@Slf4j
public class OrderController {

    private final OrderRepository orderRepository;
    private final UserRepository userRepository;
    private final ProductRepository productRepository;

    @QueryMapping
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @MutationMapping
    public CustomResponse createOrder(@Argument("userId") Long userId, @Argument("productsIds") List<Long> productsIds) throws Exception {
        Optional<User> user = userRepository.findById(userId);
        List<Product> products = productRepository.findAllById(productsIds);
        if (user.isPresent() && !products.isEmpty()) {
            double priceTotal = products.stream().mapToDouble(Product::getPrice).sum();
            Order order = new Order();
            order.setUser(user.get());
            order.setProducts(products);
            order.setPriceTotal(priceTotal);
            orderRepository.save(order);
            return new CustomResponse("success", "good");
        } else {
            return new CustomResponse("error", "error");
        }
    }


}
