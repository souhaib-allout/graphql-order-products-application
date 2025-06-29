package org.example.graphqlordersmanagment.repositories;

import org.example.graphqlordersmanagment.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
