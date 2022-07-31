package com.revature.controllers;

import com.revature.models.User;
import com.revature.repository.UserRepository;
import com.revature.services.UserService;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.yaml.snakeyaml.events.Event;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
@CrossOrigin
@RestController
@RequestMapping("/user-app")
public class UserController {

  @Autowired
  private UserService userService;

  @GetMapping("/users")
  public List<User> getUsers(@RequestParam(required = false, value = "firstName") String firstNameParam,
                             @RequestParam(required = false, value = "lastName")String lastNameParam){
    System.out.println(firstNameParam+lastNameParam);
    if(firstNameParam == null && lastNameParam == null){
      return userService.getAllUsers();
    } else {
      return userService.getUsersByFirstNameAndLastName(firstNameParam, lastNameParam);
    }
  }


    @GetMapping("/users/{userId}")
    public Optional<User> getUserById(@PathVariable("userId") int idParam){
    return userService.getUserById(idParam);
    }


//    @PostMapping("/users")
//    public User addNewUser(@RequestBody User newUser){
//        System.out.println(newUser);
//        return userService.addNewUser(newUser);
//    }

    @PostMapping("/registerNewAccount")
    public  void createNewAccount
            (HttpServletRequest request, HttpServletResponse response,
             @RequestParam(value="firstName") String firstName,
             @RequestParam(value = "lastName") String lastName,
             @RequestParam(value = "street") String street,
             @RequestParam(value = "city") String city,
             @RequestParam(value = "state") String state,
             @RequestParam(value = "zipcode") String zipcode,
             @RequestParam(value = "email") String email,
             @RequestParam(value = "password") String password,
             @RequestParam(value = "role") String role
    ) throws IOException{
      User user = new User();
      user.setFirstName(firstName);
      user.setLastName(lastName);
      user.setStreet(street);
      user.setCity(city);
      user.setState(state);
      user.setZipcode(zipcode);
      user.setEmail(email);
      user.setPassword(password);
      user.setRole(role);

      userService.addNewUser(user);
    }


    @PutMapping(value = "updatePassword")
    public void updatePassword(@RequestParam(value = "email") String email,
                               @RequestParam(value = "password") String password,
                               @RequestParam(value = "passwordConfirm") String passConfirm,

                               HttpServletRequest request, HttpServletResponse response) {

      Optional<User> newPasswordChange = userService.getUserByEmail(email);

    if(newPasswordChange.isPresent())
    {newPasswordChange.get().setPassword(password);}

      User result = userService.updateUser(newPasswordChange.get());

    }

    public void deleteUser(){

  }

}
