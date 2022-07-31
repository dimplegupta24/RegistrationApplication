package com.dimple.dao;

import com.dimple.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT u from User u WHERE u.email = ?1")
    User findByEmail(String email);
}
