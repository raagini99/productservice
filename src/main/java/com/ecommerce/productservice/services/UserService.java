package com.ecommerce.productservice.services;

import com.ecommerce.productservice.models.Instructor;
import com.ecommerce.productservice.models.Learner;
import com.ecommerce.productservice.models.User;
import com.ecommerce.productservice.repositories.InstructorRepository;
import com.ecommerce.productservice.repositories.LearnerRepository;
import com.ecommerce.productservice.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    private final InstructorRepository instructorRepository;

    private final LearnerRepository learnerRepository;

    public UserService(UserRepository userRepository, InstructorRepository instructorRepository, LearnerRepository learnerRepository) {
        this.userRepository = userRepository;
        this.instructorRepository = instructorRepository;
        this.learnerRepository = learnerRepository;
    }

    public User createInstructor(String name, String email) {
        Instructor instructor = new Instructor();
        instructor.setName(name);
        instructor.setEmail(email);
        instructor.setSalary(30000.0);
        instructor.setSkill("Backend");
        instructorRepository.save(instructor);
        return instructor;
    }

    public Optional<List<User>> getInstructorsByName(String name) {
        List<User> users = instructorRepository.findByName(name);
        return Optional.ofNullable(users);
    }

    public User createLearner(String name, String email) {
        Learner learner = new Learner();
        learner.setName(name);
        learner.setEmail(email);
        learner.setCGPA(9.0);
        learner.setPsp(100.0);
        learnerRepository.save(learner);
        return learner;
    }

    public Optional<List<User>> getLearnersByName(String name) {
        List<User> users = learnerRepository.findByName(name);
        return Optional.ofNullable(users);
    }

    /*
    public User createUser(String name, String email) {
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        userRepository.save(user);
        return user;
    }
    */

    //*
    public Optional<List<User>> getUsersByName(String name) {
        return userRepository.findByName(name);
    }
    //*/
}