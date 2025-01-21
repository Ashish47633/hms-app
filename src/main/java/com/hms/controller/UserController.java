package com.hms.controller;

import com.hms.entity.AppUser;
import com.hms.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/signup")
    public ResponseEntity<?> createUser(@Valid @RequestBody AppUser user){
        AppUser au = userService.createUser(user);
        return new ResponseEntity<>(au,HttpStatus.CREATED);

    }
    @GetMapping("/message")
    public String getMessage(){
        return "Hello";
    }

    @PostMapping("/signup-property-owner")
    public ResponseEntity<?> createPropertyOwnerUser(@RequestBody AppUser user){
        AppUser au = userService.createPropertyOwner(user);
        return new ResponseEntity<>(au,HttpStatus.CREATED);

    }

}
