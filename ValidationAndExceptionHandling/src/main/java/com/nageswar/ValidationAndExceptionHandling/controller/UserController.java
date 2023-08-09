package com.nageswar.ValidationAndExceptionHandling.controller;

import com.nageswar.ValidationAndExceptionHandling.dto.Employee;
import com.nageswar.ValidationAndExceptionHandling.dto.UserRequest;
import com.nageswar.ValidationAndExceptionHandling.entity.User;
import com.nageswar.ValidationAndExceptionHandling.exception.UserNotFoundException;
import com.nageswar.ValidationAndExceptionHandling.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable int id) throws UserNotFoundException {
        return ResponseEntity.ok(userService.getUser(id));
    }

    /*@GetMapping("/{id}")
    public User getUser(@PathVariable int id) throws UserNotFoundException {
        return userService.getUser(id);
    }*/
    @GetMapping("/names")
    List<?> getNames(){
        List<Employee> list = new ArrayList<>();
        list.add(new Employee("nag1",12,"Male"));
        list.add(new Employee("nag2",19,"Female"));
        list.add(new Employee("nag3",21,"Male"));
        list.add(new Employee("nag4",16,"Female"));
        list.add(new Employee("nag5",35,"Male"));
        list.add(new Employee("nag6",33,"Female"));
        /*return list.stream().filter(l -> l.getGender().equals("Male"))
                .filter(l -> l.getAge()>18).collect(Collectors.toList());*/

        return list.stream().filter(l -> l.getGender().equals("Male"))
                .filter(l -> l.getAge()>18)
                .filter(l -> l.getName().startsWith("na"))
                .map(l -> l.getName()).collect(Collectors.toList());
    }
}
