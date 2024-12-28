package com.hms.controller;

import com.hms.dto.LoginDto;
import com.hms.dto.TokenDto;
import com.hms.entity.AppUser;
import com.hms.repository.AppUserRepository;
import com.hms.service.LoginService;
import com.hms.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    private UserService userService;
    private LoginService loginService;


    public UserController(UserService userService, LoginService loginService, LoginService loginService1) {
        this.userService = userService;
        this.loginService = loginService1;
    }

    @PostMapping("/signup")
    public ResponseEntity<?> createUser(@RequestBody AppUser user){
        AppUser au = userService.createUser(user);
        return new ResponseEntity<>(au,HttpStatus.CREATED);

    }
    @GetMapping("/message")
    public String getMessage(){
        return "Hello";
    }


    @PostMapping("/login")
    public ResponseEntity<?>login( @RequestBody LoginDto dto) {
        String token = loginService.verifyLogin(dto);
        if (token!= null) {
            TokenDto tokenDto = new TokenDto();
            tokenDto.setToken(token);
            tokenDto.setType("JWT");
            return new ResponseEntity<>(tokenDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Invalid/username/password ", HttpStatus.FORBIDDEN);
        }

    }

}
