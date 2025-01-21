package com.hms.service;

import com.hms.entity.AppUser;
import com.hms.exception.UserNotFoundException;
import com.hms.repository.AppUserRepository;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private AppUserRepository appUserRepository;

    public UserService(AppUserRepository appUserRepository) {
        this.appUserRepository = appUserRepository;
    }


    public AppUser createUser(AppUser user)throws UserNotFoundException {
        Optional<AppUser> opUsername = appUserRepository.findByUsername(user.getUsername());

        if(opUsername.isPresent()){
            throw new UserNotFoundException("Username already taken");
        }

        Optional<AppUser> opEmail = appUserRepository.findByEmail(user.getEmail());

        if(opEmail.isPresent()) {
            throw  new UserNotFoundException("Email already taken");
        }

        String encryptedPassword = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt(6));
        user.setPassword(encryptedPassword);
        user.setRole("ROLE_USER");
        AppUser saved = appUserRepository.save(user);
        return saved;

    }


    public AppUser createPropertyOwner(AppUser user)throws UserNotFoundException {
        Optional<AppUser> opUsername = appUserRepository.findByUsername(user.getUsername());

        if(opUsername.isPresent()){
            throw new UserNotFoundException("Username already taken");
        }

        Optional<AppUser> opEmail = appUserRepository.findByEmail(user.getEmail());

        if(opEmail.isPresent()) {
            throw  new UserNotFoundException("Email already taken");
        }

        String encryptedPassword = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt(6));
        user.setPassword(encryptedPassword);
        user.setRole("ROLE_OWNER");
        AppUser saved = appUserRepository.save(user);
        return saved;

    }



}
