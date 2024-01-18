package com.technical.bci.technical_test_bci.repositories;

import com.technical.bci.technical_test_bci.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
