package com.example.stronka.Service;

import com.example.stronka.temp.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserService extends JpaRepository<User,Long> {
    List<User> findByEmail(String email);
}
