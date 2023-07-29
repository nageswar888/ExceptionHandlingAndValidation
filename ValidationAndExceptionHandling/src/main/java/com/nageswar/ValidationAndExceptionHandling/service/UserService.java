package com.nageswar.ValidationAndExceptionHandling.service;

import com.nageswar.ValidationAndExceptionHandling.dto.UserRequest;
import com.nageswar.ValidationAndExceptionHandling.entity.User;
import com.nageswar.ValidationAndExceptionHandling.exception.UserNotFoundException;
import com.nageswar.ValidationAndExceptionHandling.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User saveUser(UserRequest userRequest){
        User user = User.build(
                0,
                userRequest.getName(),
                userRequest.getMobile(),
                userRequest.getGender(),
                userRequest.getEmail(),
                userRequest.getAge(),
                userRequest.getNationality());

        return userRepository.save(user);
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User getUser(int id) throws UserNotFoundException {
        User user = userRepository.findByUserId(id);
        if(user != null){
            return userRepository.findByUserId(id);
        }
        else{
            throw new UserNotFoundException("User not found with the id "+ id);
        }
        //return userRepository.findByUserId(id);
    }
}
