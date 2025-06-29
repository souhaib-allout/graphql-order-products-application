package org.example.graphqlordersmanagment.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "orders")
@Getter
@Setter
@NoArgsConstructor
public class Order {
    @Id
    @GeneratedValue
    private Long id;

    @Positive(message = "the price should be positive number")
    private double priceTotal;

    @OneToMany
    private List<Product> products;

    @ManyToOne
    private User user;
}
