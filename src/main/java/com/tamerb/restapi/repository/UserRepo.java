package com.tamerb.restapi.repository;

import com.tamerb.restapi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
}
