package com.example.zj.company.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.io.Serializable;

public interface UserRepository extends JpaRepository<User, Serializable>, JpaSpecificationExecutor<User> {
    @Query(value = "select * from users where username = ?1", nativeQuery = true)
    User getUserByUsername(String account);
}
