package com.microservices.tech.vt.user_services.user_services.repository;

import com.microservices.tech.vt.user_services.user_services.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUserId(Long userId);
}
