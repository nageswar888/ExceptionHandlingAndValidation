package com.nageswar.ValidationAndExceptionHandling.repository;

import com.nageswar.ValidationAndExceptionHandling.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUserId(int id);
}
