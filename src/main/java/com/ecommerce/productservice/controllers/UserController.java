package com.ecommerce.productservice.controllers;

import com.ecommerce.productservice.dtos.CreateUserDto;
import com.ecommerce.productservice.dtos.GetInstructorDto;
import com.ecommerce.productservice.dtos.GetLearnerDto;
import com.ecommerce.productservice.models.Instructor;
import com.ecommerce.productservice.models.Learner;
import com.ecommerce.productservice.models.User;
import com.ecommerce.productservice.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static java.util.Optional.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("")
    public User createUser(@RequestBody CreateUserDto createUserDto) {
        return userService.
                createUser(createUserDto.getName(), createUserDto.getEmail());
    }

    @PostMapping("/instructor")
    public Instructor createInstructor(@RequestBody CreateUserDto createUserDto) {
        return userService.
                createInstructor(createUserDto.getName(), createUserDto.getEmail());
    }

    @PostMapping("/learner")
    public Learner createLearner(@RequestBody GetLearnerDto getLearnerDto)
    {
        return userService.createLearner(getLearnerDto.getName(), getLearnerDto.getEmail(), getLearnerDto.getUniversity());
    }

    @GetMapping("/{name}")
    public Optional<List<User>> getUserByName(@PathVariable(name = "name") String name) {
        return userService.getUserByName(name);
    }

    @GetMapping("/instructor/{name}")
    public List<GetInstructorDto> getInstructorByName(@PathVariable(name = "name") String name) {
        return userService.getInstructorByName(name);
    }

    @GetMapping("/instructor")
    public List<GetInstructorDto> getInstructorByUUID(@RequestBody List<UUID> uuid) {
        return userService.getInstructorByIds(uuid);
    }

    @GetMapping("/learner")
    public Optional<GetLearnerDto> getLearnerByEmail(@RequestParam String email)
    {
        return ofNullable(userService.getLearnerByEmail(email));
    }
}
