package com.example.stronka.Registration;

import com.example.stronka.User.UserRole;

public record RegistrationRequest(String name, String email, String password, UserRole role) {
}
