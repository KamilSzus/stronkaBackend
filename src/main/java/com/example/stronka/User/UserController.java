package com.example.stronka.User;

import lombok.AllArgsConstructor;
import lombok.experimental.Delegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@AllArgsConstructor
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserRepository userRepository;

    UserService userService;

    @GetMapping("/getAllUser")
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> userList = new ArrayList<>(userRepository.findAll());
        if(userList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(userList, HttpStatus.OK);
    }

    @DeleteMapping("/deleteUser/{email}")
    public ResponseEntity<User> deleteUser(@PathVariable String email){
        List<User> user = userRepository.deleteByEmail(email);
        if(!user.isEmpty()){
            return new ResponseEntity<>(user.get(0),HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/createUser")
    public ResponseEntity<User> createUser(@RequestBody User user){
        try{
            User newUser = userRepository.save(new User(user.getEmail(), user.getName(), user.getPassword(), user.getRole()));
            return new ResponseEntity<>(newUser, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
