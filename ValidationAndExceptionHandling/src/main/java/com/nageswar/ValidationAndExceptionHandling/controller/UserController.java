package com.nageswar.ValidationAndExceptionHandling.controller;

import com.nageswar.ValidationAndExceptionHandling.dto.UserRequest;
import com.nageswar.ValidationAndExceptionHandling.entity.User;
import com.nageswar.ValidationAndExceptionHandling.exception.UserNotFoundException;
import com.nageswar.ValidationAndExceptionHandling.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<User> saveUser(@RequestBody @Valid UserRequest userRequest){
        return new ResponseEntity<>(userService.saveUser(userRequest), HttpStatus.OK);
    }
    @GetMapping("/fetchAll")
    public ResponseEntity<List<User>> getAllUsers(){
        return ResponseEntity.ok(userService.getAllUsers());
    }
    /*@GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable int id){
        return ResponseEntity.ok(userService.getUser(id));
    }*/

    @GetMapping("/{id}")
    public User getUser(@PathVariable int id) throws UserNotFoundException {
        return userService.getUser(id);
    }
}
