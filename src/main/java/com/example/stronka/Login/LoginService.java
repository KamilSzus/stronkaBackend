package com.example.stronka.Login;

import com.example.stronka.User.User;
import com.example.stronka.User.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class LoginService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder encoder;

    public User loginUser(LoginRequest loginRequest){
        Optional<User> user = userRepository.findByEmail(loginRequest.email());

        if(user.isPresent()){
            if(encoder.matches(loginRequest.password(),user.get().getPassword())){
                return user.get();
            }
            return null;
        }
        return null;
    }
}
