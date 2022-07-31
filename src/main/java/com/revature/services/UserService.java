package com.revature.services;

import com.revature.models.User;
import com.revature.repository.ClaimRepository;
import com.revature.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired private UserRepository repository;

    @Autowired private ClaimRepository claimRepository;


    public UserService() {
    }

    public List<User> getAllUsers() {
        return repository.findAll();
    }

   public User addNewUser(User newUser) {
        return repository.save(newUser);
    }

    public List<User> getUsersByFirstNameAndLastName(String firstName, String lastName){
        return repository.getUsersByFirstNameAndLastName(firstName, lastName);
    }

    public Optional<User> getUserById(int userId){
        return repository.findById(userId);
    }

    public Optional<User> getUserByEmail(String email){
        return repository.findByEmail(email);
    }

    public User updateUser(User user) {
        return repository.save(user);
    }
}
