package com.ecommerce.productservice.services;

import com.ecommerce.productservice.dtos.GetInstructorDto;
import com.ecommerce.productservice.models.Batch;
import com.ecommerce.productservice.models.Instructor;
import com.ecommerce.productservice.models.Learner;
import com.ecommerce.productservice.models.User;
import com.ecommerce.productservice.repositories.BatchRepository;
import com.ecommerce.productservice.repositories.InstructorRepository;
import com.ecommerce.productservice.repositories.LearnerRepository;
import com.ecommerce.productservice.repositories.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    private final InstructorRepository instructorRepository;

    private final LearnerRepository learnerRepository;

    private final BatchRepository batchRepository;

    public UserService(UserRepository userRepository, InstructorRepository instructorRepository, LearnerRepository learnerRepository, BatchRepository batchRepository) {
        this.userRepository = userRepository;
        this.instructorRepository = instructorRepository;
        this.learnerRepository = learnerRepository;
        this.batchRepository = batchRepository;
    }

    public GetInstructorDto createAndGetInstructor(String name, String email, List<Long> batchIds) {
        Instructor instructor = new Instructor();
        instructor.setName(name);
        instructor.setEmail(email);
        List<Batch> batches = new ArrayList<>();
        for(Long batchId : batchIds) {
            Batch batch = new Batch();
            batch.setId(batchId);
            batch.setInstructor(instructor);
            batch.setName("Batch #DummyNumber");
            batches.add(batch);
            //batchRepository.save(batch);
        }
        instructor.setBatches(batches);
        instructor.setSalary(30000.0);
        instructor.setSkill("Backend");
        instructorRepository.save(instructor);
        //batchRepository.saveAll(batches);

        instructor = instructorRepository.findByEmail(email);
        GetInstructorDto getInstructorDto = new GetInstructorDto();
        getInstructorDto.setName(instructor.getName());
        getInstructorDto.setEmail(instructor.getEmail());

        batches = instructor.getBatches();
        //batches.size();
        /*
        Iterable<Long> batchIdsIterable = new ArrayList<>(batchIds);
        batches = batchRepository.findAllById(batchIdsIterable);
        //Avoid N+1 problem.
         */
        /*
        List<Long> batchIdsList = new ArrayList<>();
        for(Batch batch : batches) {
            batchIdsList.add(batch.getId());
        }
        getInstructorDto.setBatchIds(batchIdsList);
        */

        getInstructorDto.setSalary(30000.0);
        getInstructorDto.setSkill("Backend");
        return getInstructorDto;
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