package org.example.graphqlordersmanagment.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.graphqlordersmanagment.models.User;
import org.example.graphqlordersmanagment.repositories.UserRepository;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequiredArgsConstructor
@Slf4j
public class UserController {

    private final UserRepository userRepository;

    @QueryMapping
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @MutationMapping
    public User createUser(@Valid @Argument("input") User user) {
        log.info(user.toString());
        return userRepository.save(user);
    }
}
