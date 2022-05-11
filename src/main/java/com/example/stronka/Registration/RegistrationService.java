package com.example.stronka.Registration;

import com.example.stronka.User.User;
import com.example.stronka.User.UserRole;
import com.example.stronka.User.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RegistrationService {

    private final UserService userService;
    private final EmailValidator emailValidator;

    public String register(RegistrationRequest request) {
        boolean isCorrectEmail = emailValidator.test(request.email());
        if(isCorrectEmail){
            return userService.signUpUser(new User(request.email(),request.name(),request.password(), UserRole.STANDARD_USER));
        }else{
           return "Email is incorrect";
        }
    }
}
