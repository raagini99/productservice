package com.ecommerce.productservice.models;


import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
class Learner extends User {
    Double psp;
    Double CGPA;
}