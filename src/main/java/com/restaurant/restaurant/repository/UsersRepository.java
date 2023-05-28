package com.restaurant.restaurant.repository;

import com.restaurant.restaurant.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users, Long> {
}
