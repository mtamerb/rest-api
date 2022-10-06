package com.tamerb.restapi.controller;

import com.tamerb.restapi.model.User;
import com.tamerb.restapi.repository.UserRepo;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controller {

    private final UserRepo userRepo;

    public Controller(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @GetMapping("/")
    public String getPage() {

        return "hi there!";
    }

    @GetMapping("/users")
    public List<User> getUsers() {

        return userRepo.findAll();
    }

    @PostMapping("/save")
    public User saveUser(@RequestBody User user) {

        return userRepo.save(user);
    }

    @PutMapping("/update/{id}")
    public String updateUser(@PathVariable Long id, @RequestBody User user) {
        User updatedUser = userRepo.findById(id).get();
        updatedUser.setFirstName(user.getFirstName());
        updatedUser.setLastName(user.getLastName());
        updatedUser.setAge(user.getAge());
        updatedUser.setProfession(user.getProfession());
        userRepo.save(updatedUser);

        return "Updated...";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable Long id) {
        User deleteUser = userRepo.findById(id).get();
        userRepo.delete(deleteUser);

        return "Delete user with the id : " + id;
    }

}
