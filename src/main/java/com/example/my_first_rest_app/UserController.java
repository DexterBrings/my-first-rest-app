package com.example.my_first_rest_app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;


@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody User newUser){
        // generate secret
        newUser.setSecret(UUID.randomUUID().toString());

        var savedUser = userRepository.save(newUser);
        return new ResponseEntity<User>((User) savedUser, HttpStatus.CREATED);
    }

    @GetMapping("/user")
    public ResponseEntity<User> register(@RequestParam(value = "id") int id) {
        var user = userRepository.findById(id);

        if (user.isPresent()) {

            return new ResponseEntity<User>(user.get(), HttpStatus.OK);

        }

        return new ResponseEntity("No user found with id " + id, HttpStatus.OK);
    }

    @GetMapping("/validate")
    public  ResponseEntity<String> validate(@RequestParam(value = "email") String email,
                                         @RequestParam(value = "password") String password) {

       var validUser = userRepository.findByEmailAndPassword(email, password);

       if (validUser.isPresent()){
           return new ResponseEntity<String>("API Secret: " + validUser.get().getSecret(), HttpStatus.OK);
       }
       return new ResponseEntity("Keine Daten gefunden!", HttpStatus.NOT_FOUND);

    }
}
