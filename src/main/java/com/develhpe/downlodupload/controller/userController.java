package com.develhpe.downlodupload.controller;

import com.develhpe.downlodupload.entity.User;
import com.develhpe.downlodupload.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class userController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping
    public void createUser(@RequestBody User user) {
    userRepository.save(user);
    }

    @GetMapping
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @GetMapping(path = "/{id}")
    public Optional<User> findById(@PathVariable("id") Long id) {
        return userRepository.findById(id);
    }

    @PutMapping("/{id}")
    public void updateUser(@PathVariable Long id, @RequestBody User user) {
        user.setId(id);
        userRepository.save(user);

    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userRepository.deleteById(id);
    }

    @PostMapping("/{id}/profile")
    public void uploadProfilePicture(){

    }

    @GetMapping("/{id}/profile")
    public void findUserProfilePicture(@PathVariable Long id){

    }

}
