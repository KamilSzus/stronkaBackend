package com.example.stronka.Registration;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/registration")
public class RegistrationController {

    private final RegistrationService registrationService;

    @PostMapping
    public ResponseEntity<String> register(@RequestBody RegistrationRequest request) {
        String response = registrationService.register(request);
        return switch (response) {
            case "Created" -> new ResponseEntity<>(response, HttpStatus.OK);
            case "Email is taken" -> new ResponseEntity<>(response, HttpStatus.I_AM_A_TEAPOT);
            case "Email is incorrect" -> new ResponseEntity<>(response, HttpStatus.NOT_ACCEPTABLE);
            default -> new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        };
    }
}
