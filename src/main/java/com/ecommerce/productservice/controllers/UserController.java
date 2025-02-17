package com.ecommerce.productservice.controllers;


import com.ecommerce.productservice.dtos.CreateUserDto;
import com.ecommerce.productservice.models.Instructor;
import com.ecommerce.productservice.models.Learner;
import com.ecommerce.productservice.models.User;
import com.ecommerce.productservice.services.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.List;

@RestController
@RequestMapping("/users")
class UserController {
    private UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/instructors")
    public User createInstructor(@RequestBody CreateUserDto createUserDto) {
        return userService.createInstructor(createUserDto.getName(), createUserDto.getEmail());
    }

    @GetMapping("/instructors/{name}")
    public @ResponseBody Optional<List<User>> getInstructorsByName(@PathVariable("name") String name) {
        return userService.getInstructorsByName(name);
    }

    @PostMapping("/learners")
    public User createLearner(@RequestBody CreateUserDto createUserDto) {
        return userService.createLearner(createUserDto.getName(), createUserDto.getEmail());
    }

    @GetMapping("/learners/{name}")
    public @ResponseBody Optional<List<User>> getLearnersByName(@PathVariable("name") String name) {
        return userService.getLearnersByName(name);
    }

    @GetMapping("/{name}")
    public @ResponseBody Optional<List<User>> getUsersByName(@PathVariable("name") String name) {
        return userService.getUsersByName(name);
    }

    /*
    @PostMapping("")
    public @ResponseBody User createUser(@RequestBody CreateUserDto createUserDto) {
        return userService.createUser(createUserDto.name, createUserDto.email);
    }
    */

    /*
    @GetMapping("/{name}")
    public @ResponseBody Optional<User> getUser(@PathVariable("name") String name) {
        return userService.getUserByName(name);
    }
    */
}