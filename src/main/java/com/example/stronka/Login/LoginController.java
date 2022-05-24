package com.example.stronka.Login;

import com.example.stronka.User.User;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@AllArgsConstructor
@RequestMapping("/login")
public class LoginController {

    private final LoginService loginService;

    @PostMapping("/user")
    public ResponseEntity<User> loginUser(@RequestBody LoginRequest loginRequest) {
        User user = loginService.loginUser(loginRequest);

        if (user != null) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
        }
    }

}
