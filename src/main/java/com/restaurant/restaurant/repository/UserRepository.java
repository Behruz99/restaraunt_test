package com.restaurant.restaurant.repository;

import com.restaurant.restaurant.domin.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User,Long> {
    User findByUserName(String userUser);
    @Query("select u from User u where u.userName=:userName")
    User findByLogin(@Param("userName")String userName);


    boolean existsByUserName(String userName);
}
